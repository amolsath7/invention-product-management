package com.amdocs.ensemble.interfaces.rest;

import com.amdocs.ensemble.domain.InventionProductResponse;
import com.amdocs.ensemble.entity.InventionProduct;
import com.amdocs.ensemble.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IInventionProductResourceAPI {
    /**
     * @param contentType
     * @param product
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/add-product-details", consumes = {"application/json;charset=UTF-8"}, produces = {"application/json;charset=UTF-8"})
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<InventionProduct> addProductDetails(@RequestHeader(value = "Content-Type", required = true) String contentType, @RequestBody InventionProduct product);

    /**
     * @param contentType
     * @param product
     * @return
     * @throws DataNotFoundException
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/update-product-details", consumes = {"application/json;charset=UTF-8"}, produces = {"application/json;charset=UTF-8"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<InventionProduct> updateProductDetails(@RequestHeader(value = "Content-Type", required = true) String contentType, @RequestBody InventionProduct product) throws DataNotFoundException;


    /**
     * @param projectId
     * @param contentType
     * @return
     * @throws DataNotFoundException
     */
    @RequestMapping(method = RequestMethod.GET, value = "/get-product-details/{projectId}", consumes = {"application/json;charset=UTF-8"}, produces = {"application/json;charset=UTF-8"})
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<InventionProduct> getProductDetailsById(@PathVariable String projectId, @RequestHeader(value = "Content-Type", required = true) String contentType) throws DataNotFoundException;


    /**
     * @param contentType
     * @return
     * @throws DataNotFoundException
     */
    @RequestMapping(method = RequestMethod.GET, value = "/get-product-details", consumes = {"application/json;charset=UTF-8"}, produces = {"application/json;charset=UTF-8"})
    @ResponseStatus(value = HttpStatus.OK)
    public InventionProductResponse<List<InventionProduct>> getProductDetails(@RequestHeader(value = "Content-Type", required = true) String contentType) throws DataNotFoundException;


    @RequestMapping(method = RequestMethod.PUT, value = "/accept-reject-product-details", consumes = {"application/json;charset=UTF-8"}, produces = {"application/json;charset=UTF-8"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<InventionProduct> acceptRejectProductDetails(@RequestHeader(value = "Content-Type", required = true) String contentType, @RequestBody InventionProduct product) throws DataNotFoundException;


}
