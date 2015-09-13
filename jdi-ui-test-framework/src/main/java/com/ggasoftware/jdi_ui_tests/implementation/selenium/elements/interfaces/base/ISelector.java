package com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.interfaces.base;

import com.ggasoftware.jdi_ui_tests.implementation.selenium.elements.page_objects.annotations.JDIAction;

import java.util.List;

/**
 * Created by Roman_Iovlev on 6/10/2015.
 */
public interface ISelector<TEnum extends Enum> extends IBaseElement, ISetValue {
    /** Select Element with name (use text) from list */
    @JDIAction
    void select(String name);
    /** Select Element with name (use enum) from list */
    @JDIAction
    void select(TEnum name);
    /** Select Element with name (use index) from list */
    @JDIAction
    void select(int index);
    /** Get name of the selected Element */
    @JDIAction
    String isSelected();
    /** Wait while option (from text) is selected. Return false if this not happens */
    @JDIAction
    boolean waitSelected(String name);
    /** Wait while option (from enum) is selected. Return false if this not happens */
    @JDIAction
    boolean waitSelected(TEnum name);
    /** Get labels of all options */
    @JDIAction
    List<String> getOptions();
    /** Get all options labels in one string separated with “; ” */
    @JDIAction
    String getOptionsAsText();
}
