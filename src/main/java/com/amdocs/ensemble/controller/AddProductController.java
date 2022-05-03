package com.amdocs.ensemble.controller;

import com.amdocs.ensemble.entity.InventionProduct;
import com.amdocs.ensemble.interfaces.controller.IAddProductController;
import com.amdocs.ensemble.interfaces.service.IInventionProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class AddProductController implements IAddProductController {
    private final Logger log = LoggerFactory.getLogger(AddProductController.class);

    @Autowired
    IInventionProductService inventionProductService;

    /**
     * @param product
     */
    @Override
    public void addProductDetails(InventionProduct product) {
        log.info("In InventionProductController - addProductDetails");
        inventionProductService.addProductDetailsDb(product);
    }


}
