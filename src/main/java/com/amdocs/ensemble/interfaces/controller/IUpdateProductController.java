package com.amdocs.ensemble.interfaces.controller;

import com.amdocs.ensemble.entity.InventionProduct;
import com.amdocs.ensemble.exception.DataNotFoundException;

public interface IUpdateProductController {
    /**
     * @param product
     * @throws DataNotFoundException
     */
    void updateProductDetails(InventionProduct product) throws DataNotFoundException;


}
