/****************************************************************************
 * Copyright (C) 2014 GGA Software Services LLC
 *
 * This file may be distributed and/or modified under the terms of the
 * GNU General Public License version 3 as published by the Free Software
 * Foundation.
 *
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 ***************************************************************************/
package com.epam.ui_test_framework.elements.complex;

import com.epam.ui_test_framework.elements.base.SetValue;
import com.epam.ui_test_framework.elements.common.TextField;
import com.epam.ui_test_framework.elements.interfaces.complex.IComboBox;
import org.openqa.selenium.*;

/**
 * ComboBox control implementation
 *
 * @author Alexeenko Yan
 */
public class ComboBox<TEnum extends Enum> extends Dropdown<TEnum> implements IComboBox<TEnum> {
    public ComboBox() { super(); }
    public ComboBox(By valueLocator) {
        super(valueLocator);
        textFieldLocator = valueLocator;
    }
    public ComboBox(By selectorLocator, By optionsNamesLocatorTemplate) {
        super(selectorLocator, optionsNamesLocatorTemplate);
        textFieldLocator = selectorLocator;
    }
    public ComboBox(By selectorLocator, By optionsNamesLocatorTemplate, By valueLocator) {
        super(selectorLocator, optionsNamesLocatorTemplate);
        textFieldLocator = valueLocator;
    }
    public ComboBox(By selectorLocator, By optionsNamesLocatorTemplate, By valueLocator, By allOptionsNamesLocator) {
        super(selectorLocator, optionsNamesLocatorTemplate, allOptionsNamesLocator);
        textFieldLocator = valueLocator;
    }
    protected By textFieldLocator;
    protected TextField textField() { return new TextField(textFieldLocator); }

    protected void inputAction(String text) { textField().input(text); }
    protected void clearAction() { textField().clear(); }
    protected void focusAction() { textField().focus(); }

    @Override
    protected SetValue setValue() {
        return new SetValue( this::newInput, textField()::getText);
    }

    public final void input(String text) { textField().input(text); }
    public final void sendKeys(String text) { input(text); }
    public final void newInput(String text) { textField().newInput(text); }
    public final void clear() { textField().clear(); }
    public final void focus() { textField().focus(); }

}
