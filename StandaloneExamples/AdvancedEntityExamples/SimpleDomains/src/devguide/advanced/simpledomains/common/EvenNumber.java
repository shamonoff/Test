package devguide.advanced.simpledomains.common;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jbo.JboException;
import oracle.jbo.domain.DataCreationException;
import oracle.jbo.domain.DatumFactory;
import oracle.jbo.domain.DomainInterface;
import oracle.jbo.domain.DomainOwnerInterface;
import oracle.jbo.domain.Number;

import oracle.sql.*;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EvenNumber extends Number {
    static ORADataFactory fac;

    public EvenNumber(Object value) throws SQLException {
        super(value);
        validate();
    }

    public EvenNumber(String value) throws SQLException {
        super(new BigDecimal(value));
        validate();
    }

    public EvenNumber(BigInteger value) throws SQLException {
        super(value);
        validate();
    }

    public EvenNumber(BigDecimal value) throws SQLException {
        super(value);
        validate();
    }

    public EvenNumber(double value) throws SQLException {
        super(value);
        validate();
    }

    public EvenNumber(float value) {
        super(value);
        validate();
    }

    public EvenNumber(long value) {
        super(value);
        validate();
    }

    public EvenNumber(short value) {
        super(value);
        validate();
    }

    public EvenNumber(int value) {
        super(value);
        validate();
    }

    public EvenNumber(byte[] value) {
        super(value);
        validate();
    }

    public EvenNumber(byte value) {
        super(value);
        validate();
    }

    public EvenNumber(boolean value) {
        super(value);
        validate();
    }

    public EvenNumber(NUMBER value) {
        super(value.getBytes());
        validate();
    }

    public EvenNumber(Number value) {
        super(value.getBytes());
        validate();
    }

    public EvenNumber() {
    }

    /**Implements domain validation logic and throws a JboException on error.
     */
    protected void validate() {
        /**
        * Validates that value is an even number, otherwise,
        * throws a DataCreationException with a custom
        * error message.
        */
        if (getValue() % 2 == 1) {
        throw new DataCreationException(ErrorMessages.class,
        ErrorMessages.INVALID_EVENNUMBER,null,null);
        }
    }

    public static ORADataFactory getORADataFactory() {
        if (fac == null) {
            class facClass implements DatumFactory {
                public Datum createDatum(CallableStatement jdbc, 
                                         int index) throws SQLException {
                    byte[] data = jdbc.getBytes(index);
                    return (data != null) ? new EvenNumber(data) : null;
                }

                public Datum createDatum(ResultSet jdbc, 
                                         int index) throws SQLException {
                    byte[] data = jdbc.getBytes(index);
                    return (data != null) ? new EvenNumber(data) : null;
                }

                public ORAData create(Datum d, 
                                      int sql_type_code) throws SQLException {
                    if (d != null) {
                        return new EvenNumber(d.getBytes());
                    }
                    return null;
                }
            }
            fac = new facClass();
        }
        return fac;
    }
}
