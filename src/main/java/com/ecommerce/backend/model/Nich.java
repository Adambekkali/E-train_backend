package com.ecommerce.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "niches")
public class Nich {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "slug", nullable = false, length = Integer.MAX_VALUE)
    private String slug;

    @ColumnDefault("0")
    @Column(name = "trend_score", nullable = false, precision = 5, scale = 2)
    private BigDecimal trendScore;

    @ColumnDefault("0")
    @Column(name = "competition_level", nullable = false, precision = 5, scale = 2)
    private BigDecimal competitionLevel;

    @ColumnDefault("0")
    @Column(name = "seasonality_index", nullable = false, precision = 5, scale = 2)
    private BigDecimal seasonalityIndex;

    @ColumnDefault("'{}'")
    @Column(name = "google_trends_snapshot", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> googleTrendsSnapshot;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public BigDecimal getTrendScore() {
        return trendScore;
    }

    public void setTrendScore(BigDecimal trendScore) {
        this.trendScore = trendScore;
    }

    public BigDecimal getCompetitionLevel() {
        return competitionLevel;
    }

    public void setCompetitionLevel(BigDecimal competitionLevel) {
        this.competitionLevel = competitionLevel;
    }

    public BigDecimal getSeasonalityIndex() {
        return seasonalityIndex;
    }

    public void setSeasonalityIndex(BigDecimal seasonalityIndex) {
        this.seasonalityIndex = seasonalityIndex;
    }

    public Map<String, Object> getGoogleTrendsSnapshot() {
        return googleTrendsSnapshot;
    }

    public void setGoogleTrendsSnapshot(Map<String, Object> googleTrendsSnapshot) {
        this.googleTrendsSnapshot = googleTrendsSnapshot;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

}