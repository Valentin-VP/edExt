/**
 * DtCurso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtCurso  extends publicadores.DtCursoBase  implements java.io.Serializable {
    private int cantHoras;

    private java.lang.String[] categorias;

    private java.lang.Integer creditos;

    private java.lang.String descripcion;

    private java.lang.String duracion;

    private publicadores.DtEdicionBase[] ediciones;

    private publicadores.DtFecha fechaR;

    private publicadores.DtCursoBase[] previas;

    private java.lang.String url;

    public DtCurso() {
    }

    public DtCurso(
           java.lang.String nombre,
           int cantHoras,
           java.lang.String[] categorias,
           java.lang.Integer creditos,
           java.lang.String descripcion,
           java.lang.String duracion,
           publicadores.DtEdicionBase[] ediciones,
           publicadores.DtFecha fechaR,
           publicadores.DtCursoBase[] previas,
           java.lang.String url) {
        super(
            nombre);
        this.cantHoras = cantHoras;
        this.categorias = categorias;
        this.creditos = creditos;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.ediciones = ediciones;
        this.fechaR = fechaR;
        this.previas = previas;
        this.url = url;
    }


    /**
     * Gets the cantHoras value for this DtCurso.
     * 
     * @return cantHoras
     */
    public int getCantHoras() {
        return cantHoras;
    }


    /**
     * Sets the cantHoras value for this DtCurso.
     * 
     * @param cantHoras
     */
    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }


    /**
     * Gets the categorias value for this DtCurso.
     * 
     * @return categorias
     */
    public java.lang.String[] getCategorias() {
        return categorias;
    }


    /**
     * Sets the categorias value for this DtCurso.
     * 
     * @param categorias
     */
    public void setCategorias(java.lang.String[] categorias) {
        this.categorias = categorias;
    }

    public java.lang.String getCategorias(int i) {
        return this.categorias[i];
    }

    public void setCategorias(int i, java.lang.String _value) {
        this.categorias[i] = _value;
    }


    /**
     * Gets the creditos value for this DtCurso.
     * 
     * @return creditos
     */
    public java.lang.Integer getCreditos() {
        return creditos;
    }


    /**
     * Sets the creditos value for this DtCurso.
     * 
     * @param creditos
     */
    public void setCreditos(java.lang.Integer creditos) {
        this.creditos = creditos;
    }


    /**
     * Gets the descripcion value for this DtCurso.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this DtCurso.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the duracion value for this DtCurso.
     * 
     * @return duracion
     */
    public java.lang.String getDuracion() {
        return duracion;
    }


    /**
     * Sets the duracion value for this DtCurso.
     * 
     * @param duracion
     */
    public void setDuracion(java.lang.String duracion) {
        this.duracion = duracion;
    }


    /**
     * Gets the ediciones value for this DtCurso.
     * 
     * @return ediciones
     */
    public publicadores.DtEdicionBase[] getEdiciones() {
        return ediciones;
    }


    /**
     * Sets the ediciones value for this DtCurso.
     * 
     * @param ediciones
     */
    public void setEdiciones(publicadores.DtEdicionBase[] ediciones) {
        this.ediciones = ediciones;
    }

    public publicadores.DtEdicionBase getEdiciones(int i) {
        return this.ediciones[i];
    }

    public void setEdiciones(int i, publicadores.DtEdicionBase _value) {
        this.ediciones[i] = _value;
    }


    /**
     * Gets the fechaR value for this DtCurso.
     * 
     * @return fechaR
     */
    public publicadores.DtFecha getFechaR() {
        return fechaR;
    }


    /**
     * Sets the fechaR value for this DtCurso.
     * 
     * @param fechaR
     */
    public void setFechaR(publicadores.DtFecha fechaR) {
        this.fechaR = fechaR;
    }


    /**
     * Gets the previas value for this DtCurso.
     * 
     * @return previas
     */
    public publicadores.DtCursoBase[] getPrevias() {
        return previas;
    }


    /**
     * Sets the previas value for this DtCurso.
     * 
     * @param previas
     */
    public void setPrevias(publicadores.DtCursoBase[] previas) {
        this.previas = previas;
    }

    public publicadores.DtCursoBase getPrevias(int i) {
        return this.previas[i];
    }

    public void setPrevias(int i, publicadores.DtCursoBase _value) {
        this.previas[i] = _value;
    }


    /**
     * Gets the url value for this DtCurso.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this DtCurso.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtCurso)) return false;
        DtCurso other = (DtCurso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.cantHoras == other.getCantHoras() &&
            ((this.categorias==null && other.getCategorias()==null) || 
             (this.categorias!=null &&
              java.util.Arrays.equals(this.categorias, other.getCategorias()))) &&
            ((this.creditos==null && other.getCreditos()==null) || 
             (this.creditos!=null &&
              this.creditos.equals(other.getCreditos()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.duracion==null && other.getDuracion()==null) || 
             (this.duracion!=null &&
              this.duracion.equals(other.getDuracion()))) &&
            ((this.ediciones==null && other.getEdiciones()==null) || 
             (this.ediciones!=null &&
              java.util.Arrays.equals(this.ediciones, other.getEdiciones()))) &&
            ((this.fechaR==null && other.getFechaR()==null) || 
             (this.fechaR!=null &&
              this.fechaR.equals(other.getFechaR()))) &&
            ((this.previas==null && other.getPrevias()==null) || 
             (this.previas!=null &&
              java.util.Arrays.equals(this.previas, other.getPrevias()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl())));
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
        _hashCode += getCantHoras();
        if (getCategorias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategorias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategorias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCreditos() != null) {
            _hashCode += getCreditos().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getDuracion() != null) {
            _hashCode += getDuracion().hashCode();
        }
        if (getEdiciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEdiciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEdiciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFechaR() != null) {
            _hashCode += getFechaR().hashCode();
        }
        if (getPrevias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrevias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrevias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtCurso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtCurso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantHoras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantHoras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categorias");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categorias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ediciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ediciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtEdicionBase"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtFecha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "previas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtCursoBase"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
