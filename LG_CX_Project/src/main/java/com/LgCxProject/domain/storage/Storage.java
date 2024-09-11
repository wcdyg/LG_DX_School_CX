package com.LgCxProject.domain.storage;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_storage")
<<<<<<< HEAD
@IdClass(StorageId.class) // 복합 키 클래스 사용
public class Storage implements Serializable {

    @Id
    @Column(name = "storage_id") // 정확한 컬럼 이름 지정
    private String storageId; // 필드명 수정

    @Id
    @Column(name = "product_id") // 정확한 컬럼 이름 지정
    private String productId; // 필드명 수정

    @Column(name = "supplement_id") // 필요한 경우 컬럼 명시
    private String supplementId; // 필드명 수정
=======
public class Storage {

    @Id
    private String storage_id;
    @Id
    private String product_id;
>>>>>>> 7a88bb3af641395ca8e72c1bc0703399579d4b27

    private int stock;

<<<<<<< HEAD
    // Getter & Setter
    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSupplementId() {
        return supplementId;
    }

    public void setSupplementId(String supplementId) {
        this.supplementId = supplementId;
=======
    public String getStorage_id() {
        return storage_id;
    }

    public void setStorage_id(String storage_id) {
        this.storage_id = storage_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSupplement_id() {
        return supplement_id;
    }

    public void setSupplement_id(String supplement_id) {
        this.supplement_id = supplement_id;
>>>>>>> 7a88bb3af641395ca8e72c1bc0703399579d4b27
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Storage{" +
<<<<<<< HEAD
                "storageId='" + storageId + '\'' +
                ", productId='" + productId + '\'' +
                ", supplementId='" + supplementId + '\'' +
=======
                "storage_id='" + storage_id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", supplement_id='" + supplement_id + '\'' +
>>>>>>> 7a88bb3af641395ca8e72c1bc0703399579d4b27
                ", stock=" + stock +
                '}';
    }
}
