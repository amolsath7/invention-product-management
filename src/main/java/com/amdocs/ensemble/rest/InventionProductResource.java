package com.amdocs.ensemble.rest;

import com.amdocs.ensemble.domain.InventionProductResponse;
import com.amdocs.ensemble.entity.InventionProduct;
import com.amdocs.ensemble.exception.DataNotFoundException;
import com.amdocs.ensemble.interfaces.controller.IAcceptRejectProductController;
import com.amdocs.ensemble.interfaces.controller.IAddProductController;
import com.amdocs.ensemble.interfaces.controller.IUpdateProductController;
import com.amdocs.ensemble.interfaces.controller.IViewProductController;
import com.amdocs.ensemble.interfaces.rest.IInventionProductResourceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class InventionProductResource implements IInventionProductResourceAPI {
    @Autowired
    IAddProductController iAddProductController;
    @Autowired
    IUpdateProductController iUpdateProductController;
    @Autowired
    IViewProductController iViewProductController;
    @Autowired
    IAcceptRejectProductController iAcceptRejectProductController;

    /**
     * @param contentType
     * @param product
     * @return
     */
    @Override
    public ResponseEntity<InventionProduct> addProductDetails(String contentType, InventionProduct product) {
        iAddProductController.addProductDetails(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    /**
     * @param contentType
     * @param product
     * @return
     * @throws DataNotFoundException
     */
    @Override
    public ResponseEntity<InventionProduct> updateProductDetails(String contentType, InventionProduct product) throws DataNotFoundException {
        iUpdateProductController.updateProductDetails(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /**
     * @param projectId
     * @param contentType
     * @return
     * @throws DataNotFoundException
     */

    @Override
    public Optional<InventionProduct> getProductDetailsById(String projectId, String contentType) throws DataNotFoundException {
        return iViewProductController.getProductDetailsById(projectId);
    }

    /**
     * @param contentType
     * @return
     * @throws DataNotFoundException
     */
    @Override
    public InventionProductResponse<List<InventionProduct>> getProductDetails(String contentType) throws DataNotFoundException {
        List<InventionProduct> inventionProductList = iViewProductController.getProductDetails();
        return new InventionProductResponse<>(inventionProductList.size(), inventionProductList);
    }

    @Override
    public ResponseEntity<InventionProduct> acceptRejectProductDetails(String contentType, InventionProduct product) throws DataNotFoundException {
        iAcceptRejectProductController.acceptRejectProductDetails(product);
        return new ResponseEntity<>(product, HttpStatus.OK);    }

}
