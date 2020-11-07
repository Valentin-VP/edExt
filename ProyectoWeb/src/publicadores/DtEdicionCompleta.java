/**
 * DtEdicionCompleta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtEdicionCompleta  extends publicadores.DtEdicion  implements java.io.Serializable {
    private publicadores.DtInscripcionEd[] inscripciones;

    public DtEdicionCompleta() {
    }

    public DtEdicionCompleta(
           java.lang.String nombre,
           java.lang.Integer cupo,
           publicadores.DtFecha fechaF,
           publicadores.DtFecha fechaI,
           publicadores.DtFecha fechaPub,
           boolean tieneCupos,
           publicadores.DtInscripcionEd[] inscripciones) {
        super(
            nombre,
            cupo,
            fechaF,
            fechaI,
            fechaPub,
            tieneCupos);
        this.inscripciones = inscripciones;
    }


    /**
     * Gets the inscripciones value for this DtEdicionCompleta.
     * 
     * @return inscripciones
     */
    public publicadores.DtInscripcionEd[] getInscripciones() {
        return inscripciones;
    }


    /**
     * Sets the inscripciones value for this DtEdicionCompleta.
     * 
     * @param inscripciones
     */
    public void setInscripciones(publicadores.DtInscripcionEd[] inscripciones) {
        this.inscripciones = inscripciones;
    }

    public publicadores.DtInscripcionEd getInscripciones(int i) {
        return this.inscripciones[i];
    }

    public void setInscripciones(int i, publicadores.DtInscripcionEd _value) {
        this.inscripciones[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtEdicionCompleta)) return false;
        DtEdicionCompleta other = (DtEdicionCompleta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.inscripciones==null && other.getInscripciones()==null) || 
             (this.inscripciones!=null &&
              java.util.Arrays.equals(this.inscripciones, other.getInscripciones())));
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
        if (getInscripciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInscripciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInscripciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtEdicionCompleta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtEdicionCompleta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inscripciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inscripciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtInscripcionEd"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
