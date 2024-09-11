package com.LgCxProject.domain.storage;

import java.io.Serializable;
import java.util.Objects;

public class StorageId implements Serializable {

    private String storageId;
    private String productId;

    // 기본 생성자
    public StorageId() {}

    // 생성자
    public StorageId(String storageId, String productId) {
        this.storageId = storageId;
        this.productId = productId;
    }

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

    // equals and hashCode override (필수)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageId that = (StorageId) o;
        return Objects.equals(storageId, that.storageId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storageId, productId);
    }
}
