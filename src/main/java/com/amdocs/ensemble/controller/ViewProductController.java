package com.amdocs.ensemble.controller;

import com.amdocs.ensemble.entity.InventionProduct;
import com.amdocs.ensemble.exception.DataNotFoundException;
import com.amdocs.ensemble.interfaces.controller.IViewProductController;
import com.amdocs.ensemble.interfaces.service.IInventionProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ViewProductController implements IViewProductController {
    private final Logger log = LoggerFactory.getLogger(AddProductController.class);

    @Autowired
    IInventionProductService inventionProductService;


    /**
     * @param projectId
     * @return
     * @throws DataNotFoundException
     */
    @Override
    public Optional<InventionProduct> getProductDetailsById(String projectId) throws DataNotFoundException {
        log.info("In InventionProductController - getProductDetailsById");
        return inventionProductService.getProductDetailsDbById(projectId);
    }


    @Override
    public List<InventionProduct> getProductDetails() throws DataNotFoundException {
        log.info("In InventionProductController - getProductDetails");
        return inventionProductService.getProductDetailsDb();
    }
}
