package com.amdocs.ensemble.controller;

import com.amdocs.ensemble.entity.InventionProduct;
import com.amdocs.ensemble.exception.DataNotFoundException;
import com.amdocs.ensemble.interfaces.controller.IAcceptRejectProductController;
import com.amdocs.ensemble.interfaces.service.IInventionProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AcceptRejectProductController  implements IAcceptRejectProductController
{
    @Autowired
    IInventionProductService inventionProductService;

    @Override
    public void acceptRejectProductDetails(InventionProduct product) throws DataNotFoundException {
        inventionProductService.acceptRejectProductDetailsDb(product);
    }
}
