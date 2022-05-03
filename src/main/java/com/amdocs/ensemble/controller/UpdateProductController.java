package com.amdocs.ensemble.controller;

import com.amdocs.ensemble.entity.InventionProduct;
import com.amdocs.ensemble.exception.DataNotFoundException;
import com.amdocs.ensemble.interfaces.controller.IUpdateProductController;
import com.amdocs.ensemble.interfaces.service.IInventionProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UpdateProductController implements IUpdateProductController
{
    private final Logger log = LoggerFactory.getLogger(AddProductController.class);

    @Autowired
    IInventionProductService inventionProductService;

    /**
     * @param product
     * @throws DataNotFoundException
     */
    @Override
    public void updateProductDetails(InventionProduct product) throws DataNotFoundException {
        log.info("In InventionProductController - updateProductDetails");
        inventionProductService.updateProductDetailsDb(product);
    }
}
