/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.persistence.service;

import com.lab.persistence.model.ItemModel;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ItemService 
{
     public List<ItemModel> searchService(ItemModel obj) throws Exception;
}