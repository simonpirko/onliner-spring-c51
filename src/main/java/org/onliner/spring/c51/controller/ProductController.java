package org.onliner.spring.c51.controller;

import org.onliner.spring.c51.dto.seller.SellerOfferDTO;
import org.onliner.spring.c51.dto.user.AuthenticatedUserDTO;
import org.onliner.spring.c51.service.ProductService;
import org.onliner.spring.c51.service.SellerOfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static org.onliner.spring.c51.controller.UserController.ATTRIBUTE_AUTHENTICATED_USER;

@Controller
@RequestMapping("/product")
public class ProductController {
    public static final String PATH_PRODUCT_CREATE_TEMPLATE = "product/create-product";
    public static final String PATH_PRODUCT_DETAILS_TEMPLATE = "product/product-details";
    public static final String PATH_PRODUCT_OFFER_CREATION_TEMPLATE = "product/create-product-offer";
    public static final String PATH_SELLER_OFFERS_TEMPLATE = "product/seller-offers";
    public static final String ATTRIBUTE_PRODUCT_DETAILS = "productDetails";
    public static final String ATTRIBUTE_SELLER_OFFER = "sellerOffer";
    public static final String ATTRIBUTE_SELLER_OFFERS = "sellerOffers";
    private final ProductService productService;
    private final SellerOfferService sellerOfferService;

    public ProductController(ProductService productService, SellerOfferService sellerOfferService) {
        this.productService = productService;
        this.sellerOfferService = sellerOfferService;
    }

    @GetMapping("/create")
    public String getProductCreationTemplate() {
       return PATH_PRODUCT_CREATE_TEMPLATE;
    }

    @GetMapping("/{manufacturer}/{id}")
    public String getProductDetailsTemplate(@PathVariable String manufacturer, @PathVariable long id, Model model) {
        model.addAttribute(ATTRIBUTE_PRODUCT_DETAILS, productService.getProductDetailsByProductId(id));
        return PATH_PRODUCT_DETAILS_TEMPLATE;
    }

    @GetMapping("/{id}/create-offer")
    public String getProductOfferCreationTemplate(@ModelAttribute(ATTRIBUTE_SELLER_OFFER) SellerOfferDTO sellerOfferDTO,
                                                  @PathVariable("id") long productId) {
        sellerOfferDTO.setProductId(productId);
        return PATH_PRODUCT_OFFER_CREATION_TEMPLATE;
    }

    @PostMapping("/{id}/create-offer")
    public String addSellerOffer(@ModelAttribute(ATTRIBUTE_SELLER_OFFER) SellerOfferDTO sellerOfferDTO,
                                 @PathVariable("id") long productId, HttpSession httpSession) {
        AuthenticatedUserDTO authenticatedUser = (AuthenticatedUserDTO) httpSession.getAttribute(ATTRIBUTE_AUTHENTICATED_USER);
        sellerOfferDTO.setSellerManagerId(authenticatedUser.getId());
        sellerOfferDTO.setProductId(productId);
        sellerOfferService.addSellerOffer(sellerOfferDTO);
        return PATH_PRODUCT_OFFER_CREATION_TEMPLATE;
    }

    @GetMapping("/{id}/seller-offers")
    public String getSellerOffersTemplate(@PathVariable long id, Model model) {
        model.addAttribute(ATTRIBUTE_SELLER_OFFERS, sellerOfferService.findByProductId(id));
        return PATH_SELLER_OFFERS_TEMPLATE;
    }
}
