package com.harsha.springdomainevents.persistence.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseProjection {
    @Column(name = "updated_by")
    protected String updatedBy;
    @Column(name = "created_by")
    protected String createdBy;
    @Column(name = "updated_at")
    protected Long updatedAt = System.currentTimeMillis();
    @Column(name = "created_at")
    protected Long createdAt = System.currentTimeMillis();
    @Column(name = "is_active")
    protected Integer isActive = 1;

}
