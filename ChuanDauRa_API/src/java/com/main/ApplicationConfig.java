/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Man Pham
 */
@javax.ws.rs.ApplicationPath("chuandaura")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.controllers.AccountC.class);
        resources.add(com.controllers.GiangVienC.class);
        resources.add(com.controllers.KetQuaHocC.class);
        resources.add(com.controllers.NhaQuanLyC.class);
        resources.add(com.controllers.SinhVienC.class);
        resources.add(com.main.GenericResource.class);
    }
    
}



