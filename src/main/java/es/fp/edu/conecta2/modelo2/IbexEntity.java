package es.fp.edu.conecta2.modelo2;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "ibex", schema = "bolsa", catalog = "")
public class IbexEntity {
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "open", nullable = false, precision = 6)
    private BigDecimal open;
    @Basic
    @Column(name = "high", nullable = false, precision = 6)
    private BigDecimal high;
    @Basic
    @Column(name = "low", nullable = false, precision = 6)
    private BigDecimal low;
    @Basic
    @Column(name = "close", nullable = false, precision = 6)
    private BigDecimal close;
    @Basic
    @Column(name = "adj_close", nullable = false, precision = 6)
    private BigDecimal adjClose;
    @Basic
    @Column(name = "volume", nullable = false)
    private int volume;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(BigDecimal adjClose) {
        this.adjClose = adjClose;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IbexEntity that = (IbexEntity) o;

        if (volume != that.volume) return false;
        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(open, that.open)) return false;
        if (!Objects.equals(high, that.high)) return false;
        if (!Objects.equals(low, that.low)) return false;
        if (!Objects.equals(close, that.close)) return false;
        return Objects.equals(adjClose, that.adjClose);
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (open != null ? open.hashCode() : 0);
        result = 31 * result + (high != null ? high.hashCode() : 0);
        result = 31 * result + (low != null ? low.hashCode() : 0);
        result = 31 * result + (close != null ? close.hashCode() : 0);
        result = 31 * result + (adjClose != null ? adjClose.hashCode() : 0);
        result = 31 * result + volume;
        return result;
    }
}
