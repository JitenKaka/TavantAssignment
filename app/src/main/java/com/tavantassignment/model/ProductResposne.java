package com.tavantassignment.model;

import java.io.Serializable;
import java.util.List;

public class ProductResposne  implements  Serializable  {

    RatingModel ratingModel;
    String id;
    String title;
    String price;
    String description;
    String category ;
    String image ;
    String content ;

    public RatingModel getRatingModel() {
        return ratingModel;
    }

    public void setRatingModel(RatingModel ratingModel) {
        this.ratingModel = ratingModel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



  /*  List<ProductListModel> productList;

    public List<ProductListModel> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductListModel> productList) {
        this.productList = productList;
    }
*/



}
