package com.amdocs.ensemble.interfaces.controller;

import com.amdocs.ensemble.entity.InventionProduct;
import com.amdocs.ensemble.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IViewProductController {
    /**
     * @param projectId
     * @return
     * @throws DataNotFoundException
     */
    Optional<InventionProduct> getProductDetailsById(String projectId) throws DataNotFoundException;

    /**
     * @return
     * @throws DataNotFoundException
     */
    List<InventionProduct> getProductDetails() throws DataNotFoundException;
}
