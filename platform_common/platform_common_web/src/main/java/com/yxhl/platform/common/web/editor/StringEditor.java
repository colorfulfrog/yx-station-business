package com.yxhl.platform.common.web.editor;

import org.apache.commons.lang3.StringEscapeUtils;

import java.beans.PropertyEditorSupport;

/**
 * @author wangxz
 * @date 2017/3/22
 */
public class StringEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString() : "";
    }
    
}
