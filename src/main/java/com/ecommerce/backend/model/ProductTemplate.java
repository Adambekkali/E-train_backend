package com.ecommerce.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "product_templates")
public class ProductTemplate {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ColumnDefault("1")
    @Column(name = "conversion_multiplier", nullable = false, precision = 5, scale = 2)
    private BigDecimal conversionMultiplier;

    @ColumnDefault("0")
    @Column(name = "trust_bonus", nullable = false, precision = 5, scale = 2)
    private BigDecimal trustBonus;

    @ColumnDefault("0")
    @Column(name = "risk_profile", nullable = false, precision = 5, scale = 2)
    private BigDecimal riskProfile;

    @ColumnDefault("'{}'")
    @Column(name = "structure_flags", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> structureFlags;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getConversionMultiplier() {
        return conversionMultiplier;
    }

    public void setConversionMultiplier(BigDecimal conversionMultiplier) {
        this.conversionMultiplier = conversionMultiplier;
    }

    public BigDecimal getTrustBonus() {
        return trustBonus;
    }

    public void setTrustBonus(BigDecimal trustBonus) {
        this.trustBonus = trustBonus;
    }

    public BigDecimal getRiskProfile() {
        return riskProfile;
    }

    public void setRiskProfile(BigDecimal riskProfile) {
        this.riskProfile = riskProfile;
    }

    public Map<String, Object> getStructureFlags() {
        return structureFlags;
    }

    public void setStructureFlags(Map<String, Object> structureFlags) {
        this.structureFlags = structureFlags;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

}