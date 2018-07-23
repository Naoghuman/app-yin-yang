/*
 * Copyright (C) 2018 Naoghuman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.yin.yang.application;

import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.yin.yang.configuration.ApplicationConfiguration;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public class ApplicationPresenter implements 
        Initializable, ApplicationConfiguration, RegisterActions
{
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initialize(URL, ResourceBundle)"); // NOI18N
        
//        assert (apView != null) : "fx:id=\"apView\" was not injected: check your FXML file 'application.fxml'."; // NOI18N
        
        this.initializeDesktopArea();

        this.register();
    }
    
    public void initializeAfterWindowIsShowing() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.initializeAfterWindowIsShowing()"); // NOI18N
    }
    
    private void initializeDesktopArea() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.initializeDesktopArea()"); // NOI18N
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.register()"); // NOI18N
    }
    
}
