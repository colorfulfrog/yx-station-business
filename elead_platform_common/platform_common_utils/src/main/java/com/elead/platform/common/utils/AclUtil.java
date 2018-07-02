package com.elead.platform.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;

public class AclUtil {
	public static int defaultAclValue = 0;
	public static final String ACLS_KEY="acls";
	public static boolean checkAcl(int acl, int adl) {
		if (acl == 0) {
			return false;
		}
		int maxAcl =getMaxAcl(adl);
		int result = acl & maxAcl;
		//if (result >0 && result==adl) {
		if (result >0 && result<=maxAcl) {
			return true;
		}
		return false;
	}
	
	public static int getMaxAcl(int adl) {
		switch (adl) {
		case 1:
			return 1;// create
		case 2:
			return 2 + 4 + 16;// read : read+modify+down
		case 4:
			return 4;// modify
		case 8:
			return 8;// delete
		case 16:
			return 16;// down
		default:
			return adl;
		}
	}
	
	public static boolean checkListEmpty(List<?> ls){
		if(ls==null || ls.isEmpty()){
			return true;
		}
		return false;
	}
	
	public static String getSimpleClassName(String className){
		if(StringHelper.contains(className, ".")){
			return className.substring(className.lastIndexOf(".")+1);
		}
		return className;
	}
	
	
	public static List<Map<String, Object>> mergeObjectListAcl(List<String> projectIds,Map<String, Object> objectRoleAcls,Map<String, Object>  objectUserAcls){
		String objectKeyName = "projectId";
		
		if(objectRoleAcls==null || objectRoleAcls.isEmpty()){
			List<Map<String,Object>> result = AclUtil.objectAclMapToList(objectUserAcls,objectKeyName);
			projectIds.removeAll(objectUserAcls.keySet());
			List append = aclListForObjectList(projectIds,objectKeyName,defaultAclValue);
			
			if(!checkListEmpty(result)){
				result.addAll(append);
				return result;
			}
			return append;
		}
		
		if(objectUserAcls==null || objectUserAcls.isEmpty()){
			List<Map<String,Object>> result = AclUtil.objectAclMapToList(objectRoleAcls,objectKeyName);
			projectIds.removeAll(objectRoleAcls.keySet());
			List append = aclListForObjectList(projectIds,objectKeyName,defaultAclValue);
			
			if(!checkListEmpty(result)){
				result.addAll(append);
				return result;
			}
			return append;
		}
		
		
		List<Map<String, Object>>  result= new ArrayList<>();
		Iterator<String> iterator = objectRoleAcls.keySet().iterator();
		while(iterator.hasNext()){
			String objectId=iterator.next();
			
			Map<String,Integer> role_acls = (Map<String,Integer>)objectRoleAcls.get(objectId);
			Map<String,Integer> user_acls = (Map<String,Integer>)objectUserAcls.remove(objectId);
			
			Map<String,Integer> mergeAcl = AclUtil.mergeObjectAcl(role_acls,user_acls);
			Map data = new HashMap();
			data.put(objectKeyName, objectId);
			data.put(ACLS_KEY, mergeAcl);
			result.add(data);
		}
				
		if(!objectUserAcls.isEmpty()){
			result.addAll(AclUtil.objectAclMapToList(objectUserAcls,objectKeyName));
		}
		
		projectIds.removeAll(objectRoleAcls.keySet());
		projectIds.removeAll(objectUserAcls.keySet());

		if(projectIds.isEmpty()){
			return result;
		}

		List append = aclListForObjectList(projectIds,objectKeyName,defaultAclValue);
		result.addAll(append);
		return result;
	}
	
	public static Map<String,Integer> mergeObjectAcl(Map<String,Integer> source,Map<String,Integer> append){
		if(source==null){
			return append;
		}
		
		if(append==null){
			return source;
		}
		
		Iterator<String> keys= source.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			Integer t_acl = (Integer)source.get(key);
			Integer a_acl = (Integer) append.remove(key);
			if(a_acl!=null){
				source.put(key, t_acl==null?a_acl:t_acl|a_acl);
			}else{
				source.put(key, t_acl==null?0:t_acl);
			}
		}
		if(!append.isEmpty()){
			source.putAll(append);
		}
		return source;
	}
	
	public static List objectAclMapToList(Map target ,String objectKeyName){
		if(target==null || target.isEmpty()){
			return ListUtils.EMPTY_LIST;
		}
		Iterator<String> keys = target.keySet().iterator();
		List result = new ArrayList<>();
		while(keys.hasNext()){
			String key=keys.next();
			Map<String,Integer> value = (Map<String,Integer>)target.get(key);
			
			Map data = new HashMap<>();
			data.put(objectKeyName, key);
			data.put(ACLS_KEY, value);
			result.add(data);
		}
		return result;
	}
	
	public static List aclListForObjectList(List<String> objectIds, String objectKeyName,int aclValue){
		if(objectIds==null || objectIds.isEmpty()){
			return ListUtils.EMPTY_LIST;
		}
		List result = new ArrayList<>();
		for(String objectId:objectIds){
			Map data = new HashMap<>();
			data.put(objectKeyName, objectId);
			data.put(ACLS_KEY, createObjectAcl(aclValue));
			result.add(data);
		}
		return result;
	}
	
	public static Map createAclMapForObject(String objectKeyName,String objectKeyValue, int aclValue){
		Map data = new HashMap<>();
		data.put(objectKeyName, objectKeyValue);
		data.put(ACLS_KEY, createObjectAcl(aclValue));
		return data;
	}
	
	public static Map createObjectAcl(int aclValue){
		Map acls = new HashMap<>();
		acls.put("ELProject", aclValue);
		acls.put("ELTask", aclValue);
		acls.put("ELIssue", aclValue);
		acls.put("ELRisk", aclValue);
		acls.put("ELRequirement", aclValue);
		return acls;
	}
	
	public static void main(String[] args){
		List<String> contextIds = new ArrayList<>();
		contextIds.add("b029db73c4054bdba68ac27fbda76802");
    	contextIds.add("4f437bd6215a43f597ce10551d1d4cba");
    	contextIds.add("e2737a5e337b4f3a93a7c0f910aedcd8");
    	contextIds.add("c0f32e46c05d413892401087398b5924");
    	contextIds.add("79fc076de2854ae88bca32cf3a474f97");
    	//
    	contextIds.add("4b69759023974a85a1f938f57e3ac089");
    	
    	Map<String,Object>  objListRoleAcl = new HashMap<>();
    	Map<String,Object>  objListUserAcl = new HashMap<>();
    	
    	int i=1;
    	int defaultAclValue=0;
    	for(String contextIs: contextIds){
    		objListRoleAcl.put(contextIs, createObjectAcl(defaultAclValue));
    		
    		if(contextIds.size()>i){
    			Map acl = createObjectAcl(defaultAclValue);
    			acl.remove("ELProject");
    			objListUserAcl.put(contextIs,acl );
    			
    		}
    		i++;
    	}
    	
    	mergeObjectListAcl(contextIds,objListUserAcl,objListRoleAcl);
    	
	}
}
