package com.LgCxProject.domain.storage;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_storage")
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

    private int stock;

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
                "storageId='" + storageId + '\'' +
                ", productId='" + productId + '\'' +
                ", supplementId='" + supplementId + '\'' +
                ", stock=" + stock +
                '}';
    }
}
