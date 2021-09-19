package com.sensei.savedesk.web.rest.productmaster;

import com.sensei.savedesk.service.productmaster.ProductMasterService;
import com.sensei.savedesk.service.productmaster.dto.ProductMasterDTO;
import com.sensei.savedesk.web.rest.util.HeaderUtil;
import com.sensei.savedesk.web.rest.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api")
public class ProductMasterResource {
    private static final String ENTITY_NAME = "ProductMaster";

    @Value("${application.name}")
    private String applicationName;

    private final ProductMasterService productMasterService;

    @PostMapping("/productmasters")
    public ResponseEntity<ProductMasterDTO> create(@Valid @RequestBody ProductMasterDTO productMasterDTO)
            throws URISyntaxException {
        log.debug("REST request to save Customer : {}", productMasterDTO);
        ProductMasterDTO result = productMasterService.save(productMasterDTO);
        return ResponseEntity.created(new URI("/api/productmasters/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @GetMapping("/productmasters/{id}")
    public ResponseEntity<ProductMasterDTO> getproductmasterById(@PathVariable("id") Long id) throws URISyntaxException {
        Optional<ProductMasterDTO> productMaster = productMasterService.findProductMaster(id);
        return ResponseUtil.wrapOrNotFound(productMaster);
    }

    @PutMapping("/productmasters")
    public ResponseEntity<ProductMasterDTO> update(@RequestBody ProductMasterDTO productMasterDTO)
            throws URISyntaxException {
        log.debug("REST request to update productMaster : {}", productMasterDTO);
        ProductMasterDTO result = productMasterService.save(productMasterDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

        @GetMapping("/productmasters/findAllProductMaster")
        public ResponseEntity<List<ProductMasterDTO>> getAllProductMaster() {
            log.debug("Get All ProductMasters");
            List<ProductMasterDTO> productmasters = productMasterService.findProductMaster();
            return new ResponseEntity<List<ProductMasterDTO>>(productmasters, HttpStatus.OK);
        }
    }


