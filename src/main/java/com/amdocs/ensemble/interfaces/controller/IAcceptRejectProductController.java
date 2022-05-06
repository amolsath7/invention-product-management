package com.amdocs.ensemble.interfaces.controller;

import com.amdocs.ensemble.entity.InventionProduct;
import com.amdocs.ensemble.exception.DataNotFoundException;

public interface IAcceptRejectProductController
{
    void acceptRejectProductDetails(InventionProduct product) throws DataNotFoundException;

}
