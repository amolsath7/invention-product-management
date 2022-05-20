package com.amdocs.ensemble.service;

import com.amdocs.ensemble.entity.InventionProduct;
import com.amdocs.ensemble.exception.DataNotFoundException;
import com.amdocs.ensemble.interfaces.service.IInventionProductService;
import com.amdocs.ensemble.repository.IInventionProductRepository;
import com.amdocs.ensemble.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InventionProductServiceImpl implements IInventionProductService {
    private final Logger log = LoggerFactory.getLogger(InventionProductServiceImpl.class);

    @Autowired
    IInventionProductRepository iInventionProductRepository;

    /**
     * Create new ideas and submit the form so details will be stored with unique project id in db.
     * set the start date when project get created.
     */
    @Override
    public void addProductDetailsDb(InventionProduct product) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        product.setStartDate(strDate);
        product.getComments().get(0).setUserName(product.getSubmittedBy());
        product.getComments().get(0).setCommentDate(formatter.format(date));
        iInventionProductRepository.save(product);
        log.info("new idea created and stored in db");

    }

    /**
     * update the specific project so allocation will be done as per the front end UI Phase.
     * update the end date as current date when status is completed for specific project.
     */
    @Override
    public void updateProductDetailsDb(InventionProduct product) throws DataNotFoundException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        InventionProduct existingProduct = iInventionProductRepository.findById(product.getProjectId()).orElse(null);
        if (Objects.isNull(existingProduct)) {
            throw new DataNotFoundException(Constant.DATA_NOT_FOUND);

        }
        existingProduct.setProjectId(product.getProjectId());
        existingProduct.setProjectTitle(product.getProjectTitle());
        existingProduct.setProjectDescription(product.getProjectDescription());
        existingProduct.setStatus(product.getStatus());
        existingProduct.setUsefulInfo(product.getUsefulInfo());
        existingProduct.setComments(product.getComments());
        existingProduct.getComments().get(0).setUserName(product.getSubmittedBy());
        existingProduct.getComments().get(0).setCommentDate(formatter.format(date));
        existingProduct.setComplexity(product.getComplexity());
        existingProduct.setSubmittedBy(product.getSubmittedBy());
        existingProduct.setTeamMember(product.getTeamMember());
        if (product.getStatus().equalsIgnoreCase(Constant.COMPLETED)) {

            String endDate = formatter.format(date);
            existingProduct.setEndDate(endDate);
        }

        iInventionProductRepository.save(existingProduct);
        log.info("new idea updated and stored in db");

    }

    /**
     * Get the project details by using project id.
     * If the data not found for that project id then throw DataNotFoundException.
     */

    @Override
    public Optional<InventionProduct> getProductDetailsDbById(String projectId) throws DataNotFoundException {
        Optional<InventionProduct> inventionProductList = iInventionProductRepository.findById(projectId);
        if (Objects.isNull(inventionProductList)) {
            throw new DataNotFoundException(Constant.DATA_NOT_FOUND);
        }


        log.info("product details found in db for id:" + projectId);
        return inventionProductList;
    }

    /**
     * Get the all project records if nothing found any then throw DataNotFoundException
     */
    @Override
    public List<InventionProduct> getProductDetailsDb() throws DataNotFoundException {
        List<InventionProduct> inventionProductList = iInventionProductRepository.findAll();
        if (CollectionUtils.isEmpty(inventionProductList)) {
            throw new DataNotFoundException(Constant.DATA_NOT_FOUND);
        }
        log.info("product details found in db");
        return inventionProductList;
    }

    @Override
    public void acceptRejectProductDetailsDb(InventionProduct product) throws DataNotFoundException {
        InventionProduct existingProduct = iInventionProductRepository.findById(product.getProjectId()).orElse(null);
        if (Objects.isNull(existingProduct)) {
            throw new DataNotFoundException(Constant.DATA_NOT_FOUND);
        }
        existingProduct.setStatus(product.getStatus());
       // existingProduct.setComments(existingProduct.getSubmittedBy() + " - " + product.getComments());

        iInventionProductRepository.save(existingProduct);
        log.info("new idea accepted or rejected and moved to next phase or blocker phase");
    }



}
