/**
 * DtEdicion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtEdicion  extends publicadores.DtEdicionBase  implements java.io.Serializable {
    private java.lang.Integer cupo;

    private publicadores.DtFecha fechaF;

    private publicadores.DtFecha fechaI;

    private publicadores.DtFecha fechaPub;

    private boolean tieneCupos;

    public DtEdicion() {
    }

    public DtEdicion(
           java.lang.String nombre,
           java.lang.Integer cupo,
           publicadores.DtFecha fechaF,
           publicadores.DtFecha fechaI,
           publicadores.DtFecha fechaPub,
           boolean tieneCupos) {
        super(
            nombre);
        this.cupo = cupo;
        this.fechaF = fechaF;
        this.fechaI = fechaI;
        this.fechaPub = fechaPub;
        this.tieneCupos = tieneCupos;
    }


    /**
     * Gets the cupo value for this DtEdicion.
     * 
     * @return cupo
     */
    public java.lang.Integer getCupo() {
        return cupo;
    }


    /**
     * Sets the cupo value for this DtEdicion.
     * 
     * @param cupo
     */
    public void setCupo(java.lang.Integer cupo) {
        this.cupo = cupo;
    }


    /**
     * Gets the fechaF value for this DtEdicion.
     * 
     * @return fechaF
     */
    public publicadores.DtFecha getFechaF() {
        return fechaF;
    }


    /**
     * Sets the fechaF value for this DtEdicion.
     * 
     * @param fechaF
     */
    public void setFechaF(publicadores.DtFecha fechaF) {
        this.fechaF = fechaF;
    }


    /**
     * Gets the fechaI value for this DtEdicion.
     * 
     * @return fechaI
     */
    public publicadores.DtFecha getFechaI() {
        return fechaI;
    }


    /**
     * Sets the fechaI value for this DtEdicion.
     * 
     * @param fechaI
     */
    public void setFechaI(publicadores.DtFecha fechaI) {
        this.fechaI = fechaI;
    }


    /**
     * Gets the fechaPub value for this DtEdicion.
     * 
     * @return fechaPub
     */
    public publicadores.DtFecha getFechaPub() {
        return fechaPub;
    }


    /**
     * Sets the fechaPub value for this DtEdicion.
     * 
     * @param fechaPub
     */
    public void setFechaPub(publicadores.DtFecha fechaPub) {
        this.fechaPub = fechaPub;
    }


    /**
     * Gets the tieneCupos value for this DtEdicion.
     * 
     * @return tieneCupos
     */
    public boolean isTieneCupos() {
        return tieneCupos;
    }


    /**
     * Sets the tieneCupos value for this DtEdicion.
     * 
     * @param tieneCupos
     */
    public void setTieneCupos(boolean tieneCupos) {
        this.tieneCupos = tieneCupos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtEdicion)) return false;
        DtEdicion other = (DtEdicion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cupo==null && other.getCupo()==null) || 
             (this.cupo!=null &&
              this.cupo.equals(other.getCupo()))) &&
            ((this.fechaF==null && other.getFechaF()==null) || 
             (this.fechaF!=null &&
              this.fechaF.equals(other.getFechaF()))) &&
            ((this.fechaI==null && other.getFechaI()==null) || 
             (this.fechaI!=null &&
              this.fechaI.equals(other.getFechaI()))) &&
            ((this.fechaPub==null && other.getFechaPub()==null) || 
             (this.fechaPub!=null &&
              this.fechaPub.equals(other.getFechaPub()))) &&
            this.tieneCupos == other.isTieneCupos();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCupo() != null) {
            _hashCode += getCupo().hashCode();
        }
        if (getFechaF() != null) {
            _hashCode += getFechaF().hashCode();
        }
        if (getFechaI() != null) {
            _hashCode += getFechaI().hashCode();
        }
        if (getFechaPub() != null) {
            _hashCode += getFechaPub().hashCode();
        }
        _hashCode += (isTieneCupos() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtEdicion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtEdicion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cupo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cupo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtFecha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaI");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtFecha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaPub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaPub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtFecha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tieneCupos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tieneCupos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
