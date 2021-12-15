
package com.server.servicio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.server.servicio package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ModificarUsuarioResponse_QNAME = new QName("http://servicio.server.com/", "modificarUsuarioResponse");
    private final static QName _GenerarReporteBusquedaCantidad_QNAME = new QName("http://servicio.server.com/", "generarReporteBusquedaCantidad");
    private final static QName _GenerarReporteGeneral_QNAME = new QName("http://servicio.server.com/", "generarReporteGeneral");
    private final static QName _ObtenerCarritoResponse_QNAME = new QName("http://servicio.server.com/", "obtenerCarritoResponse");
    private final static QName _ObtenerDirecciones_QNAME = new QName("http://servicio.server.com/", "obtenerDirecciones");
    private final static QName _CargarArchivoDireccion_QNAME = new QName("http://servicio.server.com/", "cargarArchivoDireccion");
    private final static QName _GenerarReporteGeneralResponse_QNAME = new QName("http://servicio.server.com/", "generarReporteGeneralResponse");
    private final static QName _EliminarProducto_QNAME = new QName("http://servicio.server.com/", "eliminarProducto");
    private final static QName _ListaFacturas_QNAME = new QName("http://servicio.server.com/", "listaFacturas");
    private final static QName _IngresarProductoCompra_QNAME = new QName("http://servicio.server.com/", "ingresarProductoCompra");
    private final static QName _GenerarReporteComprasResponse_QNAME = new QName("http://servicio.server.com/", "generarReporteComprasResponse");
    private final static QName _ModificarProducto_QNAME = new QName("http://servicio.server.com/", "modificarProducto");
    private final static QName _GenerarReporteRangoFechaResponse_QNAME = new QName("http://servicio.server.com/", "generarReporteRangoFechaResponse");
    private final static QName _ModificarUsuario_QNAME = new QName("http://servicio.server.com/", "modificarUsuario");
    private final static QName _BuscarUsuario_QNAME = new QName("http://servicio.server.com/", "buscarUsuario");
    private final static QName _ListaFacturasResponse_QNAME = new QName("http://servicio.server.com/", "listaFacturasResponse");
    private final static QName _IngresarCarritoResponse_QNAME = new QName("http://servicio.server.com/", "ingresarCarritoResponse");
    private final static QName _GenerarReporteBusquedaCantidadResponse_QNAME = new QName("http://servicio.server.com/", "generarReporteBusquedaCantidadResponse");
    private final static QName _GenerarReporteBusquedaNickname_QNAME = new QName("http://servicio.server.com/", "generarReporteBusquedaNickname");
    private final static QName _ObtenerProductos_QNAME = new QName("http://servicio.server.com/", "obtenerProductos");
    private final static QName _EliminarUsuarioResponse_QNAME = new QName("http://servicio.server.com/", "eliminarUsuarioResponse");
    private final static QName _CargarArchivoUsuarioResponse_QNAME = new QName("http://servicio.server.com/", "cargarArchivoUsuarioResponse");
    private final static QName _InsertarProducto_QNAME = new QName("http://servicio.server.com/", "insertarProducto");
    private final static QName _GenerarReporteCarrito_QNAME = new QName("http://servicio.server.com/", "generarReporteCarrito");
    private final static QName _InsertarProductoResponse_QNAME = new QName("http://servicio.server.com/", "insertarProductoResponse");
    private final static QName _EliminarProductoResponse_QNAME = new QName("http://servicio.server.com/", "eliminarProductoResponse");
    private final static QName _BuscarProductoResponse_QNAME = new QName("http://servicio.server.com/", "buscarProductoResponse");
    private final static QName _GenerarReporteProductos_QNAME = new QName("http://servicio.server.com/", "generarReporteProductos");
    private final static QName _GenerarReporteUsuarios_QNAME = new QName("http://servicio.server.com/", "generarReporteUsuarios");
    private final static QName _GenerarReporteVentas_QNAME = new QName("http://servicio.server.com/", "generarReporteVentas");
    private final static QName _CargarArchivoVenta_QNAME = new QName("http://servicio.server.com/", "cargarArchivoVenta");
    private final static QName _IngresarCarrito_QNAME = new QName("http://servicio.server.com/", "ingresarCarrito");
    private final static QName _CargarArchivoCompra_QNAME = new QName("http://servicio.server.com/", "cargarArchivoCompra");
    private final static QName _GenerarReporteBusquedaFechaResponse_QNAME = new QName("http://servicio.server.com/", "generarReporteBusquedaFechaResponse");
    private final static QName _CargarArchivoDetalleResponse_QNAME = new QName("http://servicio.server.com/", "cargarArchivoDetalleResponse");
    private final static QName _CrearUsuario_QNAME = new QName("http://servicio.server.com/", "crearUsuario");
    private final static QName _LoginResponse_QNAME = new QName("http://servicio.server.com/", "LoginResponse");
    private final static QName _GenerarFactura_QNAME = new QName("http://servicio.server.com/", "generarFactura");
    private final static QName _EliminarUsuario_QNAME = new QName("http://servicio.server.com/", "eliminarUsuario");
    private final static QName _GenerarReporteRangoFecha_QNAME = new QName("http://servicio.server.com/", "generarReporteRangoFecha");
    private final static QName _CargarArchivoProducto_QNAME = new QName("http://servicio.server.com/", "cargarArchivoProducto");
    private final static QName _CargarArchivoCompraResponse_QNAME = new QName("http://servicio.server.com/", "cargarArchivoCompraResponse");
    private final static QName _ModificarProductoResponse_QNAME = new QName("http://servicio.server.com/", "modificarProductoResponse");
    private final static QName _Login_QNAME = new QName("http://servicio.server.com/", "Login");
    private final static QName _CargarArchivoUsuario_QNAME = new QName("http://servicio.server.com/", "cargarArchivoUsuario");
    private final static QName _BuscarUsuarioResponse_QNAME = new QName("http://servicio.server.com/", "buscarUsuarioResponse");
    private final static QName _CargarArchivoProductoResponse_QNAME = new QName("http://servicio.server.com/", "cargarArchivoProductoResponse");
    private final static QName _GenerarReporteUsuariosResponse_QNAME = new QName("http://servicio.server.com/", "generarReporteUsuariosResponse");
    private final static QName _GenerarReporteCarritoResponse_QNAME = new QName("http://servicio.server.com/", "generarReporteCarritoResponse");
    private final static QName _ObtenerDireccionesResponse_QNAME = new QName("http://servicio.server.com/", "obtenerDireccionesResponse");
    private final static QName _GenerarReporteBusquedaFecha_QNAME = new QName("http://servicio.server.com/", "generarReporteBusquedaFecha");
    private final static QName _CargarArchivoDetalle_QNAME = new QName("http://servicio.server.com/", "cargarArchivoDetalle");
    private final static QName _GenerarReporteProductosResponse_QNAME = new QName("http://servicio.server.com/", "generarReporteProductosResponse");
    private final static QName _CrearUsuarioResponse_QNAME = new QName("http://servicio.server.com/", "crearUsuarioResponse");
    private final static QName _GenerarReporteVentasResponse_QNAME = new QName("http://servicio.server.com/", "generarReporteVentasResponse");
    private final static QName _CargarArchivoCarro_QNAME = new QName("http://servicio.server.com/", "cargarArchivoCarro");
    private final static QName _GenerarReporteCompras_QNAME = new QName("http://servicio.server.com/", "generarReporteCompras");
    private final static QName _BuscarProducto_QNAME = new QName("http://servicio.server.com/", "buscarProducto");
    private final static QName _CargarArchivoDireccionResponse_QNAME = new QName("http://servicio.server.com/", "cargarArchivoDireccionResponse");
    private final static QName _IngresarDireccion_QNAME = new QName("http://servicio.server.com/", "ingresarDireccion");
    private final static QName _ObtenerCarrito_QNAME = new QName("http://servicio.server.com/", "obtenerCarrito");
    private final static QName _GenerarFacturaResponse_QNAME = new QName("http://servicio.server.com/", "generarFacturaResponse");
    private final static QName _IngresarDireccionResponse_QNAME = new QName("http://servicio.server.com/", "ingresarDireccionResponse");
    private final static QName _CargarArchivoVentaResponse_QNAME = new QName("http://servicio.server.com/", "cargarArchivoVentaResponse");
    private final static QName _GenerarReporteBusquedaNicknameResponse_QNAME = new QName("http://servicio.server.com/", "generarReporteBusquedaNicknameResponse");
    private final static QName _ObtenerProductosResponse_QNAME = new QName("http://servicio.server.com/", "obtenerProductosResponse");
    private final static QName _IngresarProductoCompraResponse_QNAME = new QName("http://servicio.server.com/", "ingresarProductoCompraResponse");
    private final static QName _CargarArchivoCarroResponse_QNAME = new QName("http://servicio.server.com/", "cargarArchivoCarroResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.server.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerarReporteCompras }
     * 
     */
    public GenerarReporteCompras createGenerarReporteCompras() {
        return new GenerarReporteCompras();
    }

    /**
     * Create an instance of {@link GenerarReporteVentasResponse }
     * 
     */
    public GenerarReporteVentasResponse createGenerarReporteVentasResponse() {
        return new GenerarReporteVentasResponse();
    }

    /**
     * Create an instance of {@link CargarArchivoCarro }
     * 
     */
    public CargarArchivoCarro createCargarArchivoCarro() {
        return new CargarArchivoCarro();
    }

    /**
     * Create an instance of {@link CargarArchivoDireccionResponse }
     * 
     */
    public CargarArchivoDireccionResponse createCargarArchivoDireccionResponse() {
        return new CargarArchivoDireccionResponse();
    }

    /**
     * Create an instance of {@link IngresarDireccion }
     * 
     */
    public IngresarDireccion createIngresarDireccion() {
        return new IngresarDireccion();
    }

    /**
     * Create an instance of {@link ObtenerCarrito }
     * 
     */
    public ObtenerCarrito createObtenerCarrito() {
        return new ObtenerCarrito();
    }

    /**
     * Create an instance of {@link BuscarProducto }
     * 
     */
    public BuscarProducto createBuscarProducto() {
        return new BuscarProducto();
    }

    /**
     * Create an instance of {@link GenerarFacturaResponse }
     * 
     */
    public GenerarFacturaResponse createGenerarFacturaResponse() {
        return new GenerarFacturaResponse();
    }

    /**
     * Create an instance of {@link IngresarDireccionResponse }
     * 
     */
    public IngresarDireccionResponse createIngresarDireccionResponse() {
        return new IngresarDireccionResponse();
    }

    /**
     * Create an instance of {@link CargarArchivoVentaResponse }
     * 
     */
    public CargarArchivoVentaResponse createCargarArchivoVentaResponse() {
        return new CargarArchivoVentaResponse();
    }

    /**
     * Create an instance of {@link GenerarReporteBusquedaNicknameResponse }
     * 
     */
    public GenerarReporteBusquedaNicknameResponse createGenerarReporteBusquedaNicknameResponse() {
        return new GenerarReporteBusquedaNicknameResponse();
    }

    /**
     * Create an instance of {@link CargarArchivoCarroResponse }
     * 
     */
    public CargarArchivoCarroResponse createCargarArchivoCarroResponse() {
        return new CargarArchivoCarroResponse();
    }

    /**
     * Create an instance of {@link ObtenerProductosResponse }
     * 
     */
    public ObtenerProductosResponse createObtenerProductosResponse() {
        return new ObtenerProductosResponse();
    }

    /**
     * Create an instance of {@link IngresarProductoCompraResponse }
     * 
     */
    public IngresarProductoCompraResponse createIngresarProductoCompraResponse() {
        return new IngresarProductoCompraResponse();
    }

    /**
     * Create an instance of {@link CargarArchivoDetalleResponse }
     * 
     */
    public CargarArchivoDetalleResponse createCargarArchivoDetalleResponse() {
        return new CargarArchivoDetalleResponse();
    }

    /**
     * Create an instance of {@link CrearUsuario }
     * 
     */
    public CrearUsuario createCrearUsuario() {
        return new CrearUsuario();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link GenerarFactura }
     * 
     */
    public GenerarFactura createGenerarFactura() {
        return new GenerarFactura();
    }

    /**
     * Create an instance of {@link CargarArchivoCompra }
     * 
     */
    public CargarArchivoCompra createCargarArchivoCompra() {
        return new CargarArchivoCompra();
    }

    /**
     * Create an instance of {@link GenerarReporteBusquedaFechaResponse }
     * 
     */
    public GenerarReporteBusquedaFechaResponse createGenerarReporteBusquedaFechaResponse() {
        return new GenerarReporteBusquedaFechaResponse();
    }

    /**
     * Create an instance of {@link ModificarProductoResponse }
     * 
     */
    public ModificarProductoResponse createModificarProductoResponse() {
        return new ModificarProductoResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link CargarArchivoUsuario }
     * 
     */
    public CargarArchivoUsuario createCargarArchivoUsuario() {
        return new CargarArchivoUsuario();
    }

    /**
     * Create an instance of {@link EliminarUsuario }
     * 
     */
    public EliminarUsuario createEliminarUsuario() {
        return new EliminarUsuario();
    }

    /**
     * Create an instance of {@link GenerarReporteRangoFecha }
     * 
     */
    public GenerarReporteRangoFecha createGenerarReporteRangoFecha() {
        return new GenerarReporteRangoFecha();
    }

    /**
     * Create an instance of {@link CargarArchivoProducto }
     * 
     */
    public CargarArchivoProducto createCargarArchivoProducto() {
        return new CargarArchivoProducto();
    }

    /**
     * Create an instance of {@link CargarArchivoCompraResponse }
     * 
     */
    public CargarArchivoCompraResponse createCargarArchivoCompraResponse() {
        return new CargarArchivoCompraResponse();
    }

    /**
     * Create an instance of {@link GenerarReporteCarritoResponse }
     * 
     */
    public GenerarReporteCarritoResponse createGenerarReporteCarritoResponse() {
        return new GenerarReporteCarritoResponse();
    }

    /**
     * Create an instance of {@link ObtenerDireccionesResponse }
     * 
     */
    public ObtenerDireccionesResponse createObtenerDireccionesResponse() {
        return new ObtenerDireccionesResponse();
    }

    /**
     * Create an instance of {@link BuscarUsuarioResponse }
     * 
     */
    public BuscarUsuarioResponse createBuscarUsuarioResponse() {
        return new BuscarUsuarioResponse();
    }

    /**
     * Create an instance of {@link CargarArchivoProductoResponse }
     * 
     */
    public CargarArchivoProductoResponse createCargarArchivoProductoResponse() {
        return new CargarArchivoProductoResponse();
    }

    /**
     * Create an instance of {@link GenerarReporteUsuariosResponse }
     * 
     */
    public GenerarReporteUsuariosResponse createGenerarReporteUsuariosResponse() {
        return new GenerarReporteUsuariosResponse();
    }

    /**
     * Create an instance of {@link GenerarReporteBusquedaFecha }
     * 
     */
    public GenerarReporteBusquedaFecha createGenerarReporteBusquedaFecha() {
        return new GenerarReporteBusquedaFecha();
    }

    /**
     * Create an instance of {@link CargarArchivoDetalle }
     * 
     */
    public CargarArchivoDetalle createCargarArchivoDetalle() {
        return new CargarArchivoDetalle();
    }

    /**
     * Create an instance of {@link GenerarReporteProductosResponse }
     * 
     */
    public GenerarReporteProductosResponse createGenerarReporteProductosResponse() {
        return new GenerarReporteProductosResponse();
    }

    /**
     * Create an instance of {@link CrearUsuarioResponse }
     * 
     */
    public CrearUsuarioResponse createCrearUsuarioResponse() {
        return new CrearUsuarioResponse();
    }

    /**
     * Create an instance of {@link ListaFacturasResponse }
     * 
     */
    public ListaFacturasResponse createListaFacturasResponse() {
        return new ListaFacturasResponse();
    }

    /**
     * Create an instance of {@link IngresarCarritoResponse }
     * 
     */
    public IngresarCarritoResponse createIngresarCarritoResponse() {
        return new IngresarCarritoResponse();
    }

    /**
     * Create an instance of {@link BuscarUsuario }
     * 
     */
    public BuscarUsuario createBuscarUsuario() {
        return new BuscarUsuario();
    }

    /**
     * Create an instance of {@link EliminarUsuarioResponse }
     * 
     */
    public EliminarUsuarioResponse createEliminarUsuarioResponse() {
        return new EliminarUsuarioResponse();
    }

    /**
     * Create an instance of {@link GenerarReporteBusquedaCantidadResponse }
     * 
     */
    public GenerarReporteBusquedaCantidadResponse createGenerarReporteBusquedaCantidadResponse() {
        return new GenerarReporteBusquedaCantidadResponse();
    }

    /**
     * Create an instance of {@link GenerarReporteBusquedaNickname }
     * 
     */
    public GenerarReporteBusquedaNickname createGenerarReporteBusquedaNickname() {
        return new GenerarReporteBusquedaNickname();
    }

    /**
     * Create an instance of {@link ObtenerProductos }
     * 
     */
    public ObtenerProductos createObtenerProductos() {
        return new ObtenerProductos();
    }

    /**
     * Create an instance of {@link InsertarProductoResponse }
     * 
     */
    public InsertarProductoResponse createInsertarProductoResponse() {
        return new InsertarProductoResponse();
    }

    /**
     * Create an instance of {@link EliminarProductoResponse }
     * 
     */
    public EliminarProductoResponse createEliminarProductoResponse() {
        return new EliminarProductoResponse();
    }

    /**
     * Create an instance of {@link BuscarProductoResponse }
     * 
     */
    public BuscarProductoResponse createBuscarProductoResponse() {
        return new BuscarProductoResponse();
    }

    /**
     * Create an instance of {@link CargarArchivoUsuarioResponse }
     * 
     */
    public CargarArchivoUsuarioResponse createCargarArchivoUsuarioResponse() {
        return new CargarArchivoUsuarioResponse();
    }

    /**
     * Create an instance of {@link InsertarProducto }
     * 
     */
    public InsertarProducto createInsertarProducto() {
        return new InsertarProducto();
    }

    /**
     * Create an instance of {@link GenerarReporteCarrito }
     * 
     */
    public GenerarReporteCarrito createGenerarReporteCarrito() {
        return new GenerarReporteCarrito();
    }

    /**
     * Create an instance of {@link CargarArchivoVenta }
     * 
     */
    public CargarArchivoVenta createCargarArchivoVenta() {
        return new CargarArchivoVenta();
    }

    /**
     * Create an instance of {@link IngresarCarrito }
     * 
     */
    public IngresarCarrito createIngresarCarrito() {
        return new IngresarCarrito();
    }

    /**
     * Create an instance of {@link GenerarReporteProductos }
     * 
     */
    public GenerarReporteProductos createGenerarReporteProductos() {
        return new GenerarReporteProductos();
    }

    /**
     * Create an instance of {@link GenerarReporteUsuarios }
     * 
     */
    public GenerarReporteUsuarios createGenerarReporteUsuarios() {
        return new GenerarReporteUsuarios();
    }

    /**
     * Create an instance of {@link GenerarReporteVentas }
     * 
     */
    public GenerarReporteVentas createGenerarReporteVentas() {
        return new GenerarReporteVentas();
    }

    /**
     * Create an instance of {@link GenerarReporteGeneral }
     * 
     */
    public GenerarReporteGeneral createGenerarReporteGeneral() {
        return new GenerarReporteGeneral();
    }

    /**
     * Create an instance of {@link ModificarUsuarioResponse }
     * 
     */
    public ModificarUsuarioResponse createModificarUsuarioResponse() {
        return new ModificarUsuarioResponse();
    }

    /**
     * Create an instance of {@link GenerarReporteBusquedaCantidad }
     * 
     */
    public GenerarReporteBusquedaCantidad createGenerarReporteBusquedaCantidad() {
        return new GenerarReporteBusquedaCantidad();
    }

    /**
     * Create an instance of {@link ObtenerDirecciones }
     * 
     */
    public ObtenerDirecciones createObtenerDirecciones() {
        return new ObtenerDirecciones();
    }

    /**
     * Create an instance of {@link ObtenerCarritoResponse }
     * 
     */
    public ObtenerCarritoResponse createObtenerCarritoResponse() {
        return new ObtenerCarritoResponse();
    }

    /**
     * Create an instance of {@link EliminarProducto }
     * 
     */
    public EliminarProducto createEliminarProducto() {
        return new EliminarProducto();
    }

    /**
     * Create an instance of {@link ListaFacturas }
     * 
     */
    public ListaFacturas createListaFacturas() {
        return new ListaFacturas();
    }

    /**
     * Create an instance of {@link CargarArchivoDireccion }
     * 
     */
    public CargarArchivoDireccion createCargarArchivoDireccion() {
        return new CargarArchivoDireccion();
    }

    /**
     * Create an instance of {@link GenerarReporteGeneralResponse }
     * 
     */
    public GenerarReporteGeneralResponse createGenerarReporteGeneralResponse() {
        return new GenerarReporteGeneralResponse();
    }

    /**
     * Create an instance of {@link GenerarReporteRangoFechaResponse }
     * 
     */
    public GenerarReporteRangoFechaResponse createGenerarReporteRangoFechaResponse() {
        return new GenerarReporteRangoFechaResponse();
    }

    /**
     * Create an instance of {@link ModificarUsuario }
     * 
     */
    public ModificarUsuario createModificarUsuario() {
        return new ModificarUsuario();
    }

    /**
     * Create an instance of {@link IngresarProductoCompra }
     * 
     */
    public IngresarProductoCompra createIngresarProductoCompra() {
        return new IngresarProductoCompra();
    }

    /**
     * Create an instance of {@link GenerarReporteComprasResponse }
     * 
     */
    public GenerarReporteComprasResponse createGenerarReporteComprasResponse() {
        return new GenerarReporteComprasResponse();
    }

    /**
     * Create an instance of {@link ModificarProducto }
     * 
     */
    public ModificarProducto createModificarProducto() {
        return new ModificarProducto();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "modificarUsuarioResponse")
    public JAXBElement<ModificarUsuarioResponse> createModificarUsuarioResponse(ModificarUsuarioResponse value) {
        return new JAXBElement<ModificarUsuarioResponse>(_ModificarUsuarioResponse_QNAME, ModificarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteBusquedaCantidad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteBusquedaCantidad")
    public JAXBElement<GenerarReporteBusquedaCantidad> createGenerarReporteBusquedaCantidad(GenerarReporteBusquedaCantidad value) {
        return new JAXBElement<GenerarReporteBusquedaCantidad>(_GenerarReporteBusquedaCantidad_QNAME, GenerarReporteBusquedaCantidad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteGeneral }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteGeneral")
    public JAXBElement<GenerarReporteGeneral> createGenerarReporteGeneral(GenerarReporteGeneral value) {
        return new JAXBElement<GenerarReporteGeneral>(_GenerarReporteGeneral_QNAME, GenerarReporteGeneral.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerCarritoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "obtenerCarritoResponse")
    public JAXBElement<ObtenerCarritoResponse> createObtenerCarritoResponse(ObtenerCarritoResponse value) {
        return new JAXBElement<ObtenerCarritoResponse>(_ObtenerCarritoResponse_QNAME, ObtenerCarritoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerDirecciones }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "obtenerDirecciones")
    public JAXBElement<ObtenerDirecciones> createObtenerDirecciones(ObtenerDirecciones value) {
        return new JAXBElement<ObtenerDirecciones>(_ObtenerDirecciones_QNAME, ObtenerDirecciones.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoDireccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoDireccion")
    public JAXBElement<CargarArchivoDireccion> createCargarArchivoDireccion(CargarArchivoDireccion value) {
        return new JAXBElement<CargarArchivoDireccion>(_CargarArchivoDireccion_QNAME, CargarArchivoDireccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteGeneralResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteGeneralResponse")
    public JAXBElement<GenerarReporteGeneralResponse> createGenerarReporteGeneralResponse(GenerarReporteGeneralResponse value) {
        return new JAXBElement<GenerarReporteGeneralResponse>(_GenerarReporteGeneralResponse_QNAME, GenerarReporteGeneralResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "eliminarProducto")
    public JAXBElement<EliminarProducto> createEliminarProducto(EliminarProducto value) {
        return new JAXBElement<EliminarProducto>(_EliminarProducto_QNAME, EliminarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaFacturas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "listaFacturas")
    public JAXBElement<ListaFacturas> createListaFacturas(ListaFacturas value) {
        return new JAXBElement<ListaFacturas>(_ListaFacturas_QNAME, ListaFacturas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IngresarProductoCompra }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "ingresarProductoCompra")
    public JAXBElement<IngresarProductoCompra> createIngresarProductoCompra(IngresarProductoCompra value) {
        return new JAXBElement<IngresarProductoCompra>(_IngresarProductoCompra_QNAME, IngresarProductoCompra.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteComprasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteComprasResponse")
    public JAXBElement<GenerarReporteComprasResponse> createGenerarReporteComprasResponse(GenerarReporteComprasResponse value) {
        return new JAXBElement<GenerarReporteComprasResponse>(_GenerarReporteComprasResponse_QNAME, GenerarReporteComprasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "modificarProducto")
    public JAXBElement<ModificarProducto> createModificarProducto(ModificarProducto value) {
        return new JAXBElement<ModificarProducto>(_ModificarProducto_QNAME, ModificarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteRangoFechaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteRangoFechaResponse")
    public JAXBElement<GenerarReporteRangoFechaResponse> createGenerarReporteRangoFechaResponse(GenerarReporteRangoFechaResponse value) {
        return new JAXBElement<GenerarReporteRangoFechaResponse>(_GenerarReporteRangoFechaResponse_QNAME, GenerarReporteRangoFechaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "modificarUsuario")
    public JAXBElement<ModificarUsuario> createModificarUsuario(ModificarUsuario value) {
        return new JAXBElement<ModificarUsuario>(_ModificarUsuario_QNAME, ModificarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "buscarUsuario")
    public JAXBElement<BuscarUsuario> createBuscarUsuario(BuscarUsuario value) {
        return new JAXBElement<BuscarUsuario>(_BuscarUsuario_QNAME, BuscarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaFacturasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "listaFacturasResponse")
    public JAXBElement<ListaFacturasResponse> createListaFacturasResponse(ListaFacturasResponse value) {
        return new JAXBElement<ListaFacturasResponse>(_ListaFacturasResponse_QNAME, ListaFacturasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IngresarCarritoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "ingresarCarritoResponse")
    public JAXBElement<IngresarCarritoResponse> createIngresarCarritoResponse(IngresarCarritoResponse value) {
        return new JAXBElement<IngresarCarritoResponse>(_IngresarCarritoResponse_QNAME, IngresarCarritoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteBusquedaCantidadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteBusquedaCantidadResponse")
    public JAXBElement<GenerarReporteBusquedaCantidadResponse> createGenerarReporteBusquedaCantidadResponse(GenerarReporteBusquedaCantidadResponse value) {
        return new JAXBElement<GenerarReporteBusquedaCantidadResponse>(_GenerarReporteBusquedaCantidadResponse_QNAME, GenerarReporteBusquedaCantidadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteBusquedaNickname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteBusquedaNickname")
    public JAXBElement<GenerarReporteBusquedaNickname> createGenerarReporteBusquedaNickname(GenerarReporteBusquedaNickname value) {
        return new JAXBElement<GenerarReporteBusquedaNickname>(_GenerarReporteBusquedaNickname_QNAME, GenerarReporteBusquedaNickname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProductos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "obtenerProductos")
    public JAXBElement<ObtenerProductos> createObtenerProductos(ObtenerProductos value) {
        return new JAXBElement<ObtenerProductos>(_ObtenerProductos_QNAME, ObtenerProductos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "eliminarUsuarioResponse")
    public JAXBElement<EliminarUsuarioResponse> createEliminarUsuarioResponse(EliminarUsuarioResponse value) {
        return new JAXBElement<EliminarUsuarioResponse>(_EliminarUsuarioResponse_QNAME, EliminarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoUsuarioResponse")
    public JAXBElement<CargarArchivoUsuarioResponse> createCargarArchivoUsuarioResponse(CargarArchivoUsuarioResponse value) {
        return new JAXBElement<CargarArchivoUsuarioResponse>(_CargarArchivoUsuarioResponse_QNAME, CargarArchivoUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "insertarProducto")
    public JAXBElement<InsertarProducto> createInsertarProducto(InsertarProducto value) {
        return new JAXBElement<InsertarProducto>(_InsertarProducto_QNAME, InsertarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteCarrito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteCarrito")
    public JAXBElement<GenerarReporteCarrito> createGenerarReporteCarrito(GenerarReporteCarrito value) {
        return new JAXBElement<GenerarReporteCarrito>(_GenerarReporteCarrito_QNAME, GenerarReporteCarrito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "insertarProductoResponse")
    public JAXBElement<InsertarProductoResponse> createInsertarProductoResponse(InsertarProductoResponse value) {
        return new JAXBElement<InsertarProductoResponse>(_InsertarProductoResponse_QNAME, InsertarProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "eliminarProductoResponse")
    public JAXBElement<EliminarProductoResponse> createEliminarProductoResponse(EliminarProductoResponse value) {
        return new JAXBElement<EliminarProductoResponse>(_EliminarProductoResponse_QNAME, EliminarProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "buscarProductoResponse")
    public JAXBElement<BuscarProductoResponse> createBuscarProductoResponse(BuscarProductoResponse value) {
        return new JAXBElement<BuscarProductoResponse>(_BuscarProductoResponse_QNAME, BuscarProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteProductos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteProductos")
    public JAXBElement<GenerarReporteProductos> createGenerarReporteProductos(GenerarReporteProductos value) {
        return new JAXBElement<GenerarReporteProductos>(_GenerarReporteProductos_QNAME, GenerarReporteProductos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteUsuarios }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteUsuarios")
    public JAXBElement<GenerarReporteUsuarios> createGenerarReporteUsuarios(GenerarReporteUsuarios value) {
        return new JAXBElement<GenerarReporteUsuarios>(_GenerarReporteUsuarios_QNAME, GenerarReporteUsuarios.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteVentas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteVentas")
    public JAXBElement<GenerarReporteVentas> createGenerarReporteVentas(GenerarReporteVentas value) {
        return new JAXBElement<GenerarReporteVentas>(_GenerarReporteVentas_QNAME, GenerarReporteVentas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoVenta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoVenta")
    public JAXBElement<CargarArchivoVenta> createCargarArchivoVenta(CargarArchivoVenta value) {
        return new JAXBElement<CargarArchivoVenta>(_CargarArchivoVenta_QNAME, CargarArchivoVenta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IngresarCarrito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "ingresarCarrito")
    public JAXBElement<IngresarCarrito> createIngresarCarrito(IngresarCarrito value) {
        return new JAXBElement<IngresarCarrito>(_IngresarCarrito_QNAME, IngresarCarrito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoCompra }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoCompra")
    public JAXBElement<CargarArchivoCompra> createCargarArchivoCompra(CargarArchivoCompra value) {
        return new JAXBElement<CargarArchivoCompra>(_CargarArchivoCompra_QNAME, CargarArchivoCompra.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteBusquedaFechaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteBusquedaFechaResponse")
    public JAXBElement<GenerarReporteBusquedaFechaResponse> createGenerarReporteBusquedaFechaResponse(GenerarReporteBusquedaFechaResponse value) {
        return new JAXBElement<GenerarReporteBusquedaFechaResponse>(_GenerarReporteBusquedaFechaResponse_QNAME, GenerarReporteBusquedaFechaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoDetalleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoDetalleResponse")
    public JAXBElement<CargarArchivoDetalleResponse> createCargarArchivoDetalleResponse(CargarArchivoDetalleResponse value) {
        return new JAXBElement<CargarArchivoDetalleResponse>(_CargarArchivoDetalleResponse_QNAME, CargarArchivoDetalleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "crearUsuario")
    public JAXBElement<CrearUsuario> createCrearUsuario(CrearUsuario value) {
        return new JAXBElement<CrearUsuario>(_CrearUsuario_QNAME, CrearUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "LoginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarFactura }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarFactura")
    public JAXBElement<GenerarFactura> createGenerarFactura(GenerarFactura value) {
        return new JAXBElement<GenerarFactura>(_GenerarFactura_QNAME, GenerarFactura.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "eliminarUsuario")
    public JAXBElement<EliminarUsuario> createEliminarUsuario(EliminarUsuario value) {
        return new JAXBElement<EliminarUsuario>(_EliminarUsuario_QNAME, EliminarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteRangoFecha }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteRangoFecha")
    public JAXBElement<GenerarReporteRangoFecha> createGenerarReporteRangoFecha(GenerarReporteRangoFecha value) {
        return new JAXBElement<GenerarReporteRangoFecha>(_GenerarReporteRangoFecha_QNAME, GenerarReporteRangoFecha.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoProducto")
    public JAXBElement<CargarArchivoProducto> createCargarArchivoProducto(CargarArchivoProducto value) {
        return new JAXBElement<CargarArchivoProducto>(_CargarArchivoProducto_QNAME, CargarArchivoProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoCompraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoCompraResponse")
    public JAXBElement<CargarArchivoCompraResponse> createCargarArchivoCompraResponse(CargarArchivoCompraResponse value) {
        return new JAXBElement<CargarArchivoCompraResponse>(_CargarArchivoCompraResponse_QNAME, CargarArchivoCompraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "modificarProductoResponse")
    public JAXBElement<ModificarProductoResponse> createModificarProductoResponse(ModificarProductoResponse value) {
        return new JAXBElement<ModificarProductoResponse>(_ModificarProductoResponse_QNAME, ModificarProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "Login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoUsuario")
    public JAXBElement<CargarArchivoUsuario> createCargarArchivoUsuario(CargarArchivoUsuario value) {
        return new JAXBElement<CargarArchivoUsuario>(_CargarArchivoUsuario_QNAME, CargarArchivoUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "buscarUsuarioResponse")
    public JAXBElement<BuscarUsuarioResponse> createBuscarUsuarioResponse(BuscarUsuarioResponse value) {
        return new JAXBElement<BuscarUsuarioResponse>(_BuscarUsuarioResponse_QNAME, BuscarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoProductoResponse")
    public JAXBElement<CargarArchivoProductoResponse> createCargarArchivoProductoResponse(CargarArchivoProductoResponse value) {
        return new JAXBElement<CargarArchivoProductoResponse>(_CargarArchivoProductoResponse_QNAME, CargarArchivoProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteUsuariosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteUsuariosResponse")
    public JAXBElement<GenerarReporteUsuariosResponse> createGenerarReporteUsuariosResponse(GenerarReporteUsuariosResponse value) {
        return new JAXBElement<GenerarReporteUsuariosResponse>(_GenerarReporteUsuariosResponse_QNAME, GenerarReporteUsuariosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteCarritoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteCarritoResponse")
    public JAXBElement<GenerarReporteCarritoResponse> createGenerarReporteCarritoResponse(GenerarReporteCarritoResponse value) {
        return new JAXBElement<GenerarReporteCarritoResponse>(_GenerarReporteCarritoResponse_QNAME, GenerarReporteCarritoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerDireccionesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "obtenerDireccionesResponse")
    public JAXBElement<ObtenerDireccionesResponse> createObtenerDireccionesResponse(ObtenerDireccionesResponse value) {
        return new JAXBElement<ObtenerDireccionesResponse>(_ObtenerDireccionesResponse_QNAME, ObtenerDireccionesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteBusquedaFecha }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteBusquedaFecha")
    public JAXBElement<GenerarReporteBusquedaFecha> createGenerarReporteBusquedaFecha(GenerarReporteBusquedaFecha value) {
        return new JAXBElement<GenerarReporteBusquedaFecha>(_GenerarReporteBusquedaFecha_QNAME, GenerarReporteBusquedaFecha.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoDetalle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoDetalle")
    public JAXBElement<CargarArchivoDetalle> createCargarArchivoDetalle(CargarArchivoDetalle value) {
        return new JAXBElement<CargarArchivoDetalle>(_CargarArchivoDetalle_QNAME, CargarArchivoDetalle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteProductosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteProductosResponse")
    public JAXBElement<GenerarReporteProductosResponse> createGenerarReporteProductosResponse(GenerarReporteProductosResponse value) {
        return new JAXBElement<GenerarReporteProductosResponse>(_GenerarReporteProductosResponse_QNAME, GenerarReporteProductosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "crearUsuarioResponse")
    public JAXBElement<CrearUsuarioResponse> createCrearUsuarioResponse(CrearUsuarioResponse value) {
        return new JAXBElement<CrearUsuarioResponse>(_CrearUsuarioResponse_QNAME, CrearUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteVentasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteVentasResponse")
    public JAXBElement<GenerarReporteVentasResponse> createGenerarReporteVentasResponse(GenerarReporteVentasResponse value) {
        return new JAXBElement<GenerarReporteVentasResponse>(_GenerarReporteVentasResponse_QNAME, GenerarReporteVentasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoCarro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoCarro")
    public JAXBElement<CargarArchivoCarro> createCargarArchivoCarro(CargarArchivoCarro value) {
        return new JAXBElement<CargarArchivoCarro>(_CargarArchivoCarro_QNAME, CargarArchivoCarro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteCompras }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteCompras")
    public JAXBElement<GenerarReporteCompras> createGenerarReporteCompras(GenerarReporteCompras value) {
        return new JAXBElement<GenerarReporteCompras>(_GenerarReporteCompras_QNAME, GenerarReporteCompras.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "buscarProducto")
    public JAXBElement<BuscarProducto> createBuscarProducto(BuscarProducto value) {
        return new JAXBElement<BuscarProducto>(_BuscarProducto_QNAME, BuscarProducto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoDireccionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoDireccionResponse")
    public JAXBElement<CargarArchivoDireccionResponse> createCargarArchivoDireccionResponse(CargarArchivoDireccionResponse value) {
        return new JAXBElement<CargarArchivoDireccionResponse>(_CargarArchivoDireccionResponse_QNAME, CargarArchivoDireccionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IngresarDireccion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "ingresarDireccion")
    public JAXBElement<IngresarDireccion> createIngresarDireccion(IngresarDireccion value) {
        return new JAXBElement<IngresarDireccion>(_IngresarDireccion_QNAME, IngresarDireccion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerCarrito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "obtenerCarrito")
    public JAXBElement<ObtenerCarrito> createObtenerCarrito(ObtenerCarrito value) {
        return new JAXBElement<ObtenerCarrito>(_ObtenerCarrito_QNAME, ObtenerCarrito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarFacturaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarFacturaResponse")
    public JAXBElement<GenerarFacturaResponse> createGenerarFacturaResponse(GenerarFacturaResponse value) {
        return new JAXBElement<GenerarFacturaResponse>(_GenerarFacturaResponse_QNAME, GenerarFacturaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IngresarDireccionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "ingresarDireccionResponse")
    public JAXBElement<IngresarDireccionResponse> createIngresarDireccionResponse(IngresarDireccionResponse value) {
        return new JAXBElement<IngresarDireccionResponse>(_IngresarDireccionResponse_QNAME, IngresarDireccionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoVentaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoVentaResponse")
    public JAXBElement<CargarArchivoVentaResponse> createCargarArchivoVentaResponse(CargarArchivoVentaResponse value) {
        return new JAXBElement<CargarArchivoVentaResponse>(_CargarArchivoVentaResponse_QNAME, CargarArchivoVentaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarReporteBusquedaNicknameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "generarReporteBusquedaNicknameResponse")
    public JAXBElement<GenerarReporteBusquedaNicknameResponse> createGenerarReporteBusquedaNicknameResponse(GenerarReporteBusquedaNicknameResponse value) {
        return new JAXBElement<GenerarReporteBusquedaNicknameResponse>(_GenerarReporteBusquedaNicknameResponse_QNAME, GenerarReporteBusquedaNicknameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProductosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "obtenerProductosResponse")
    public JAXBElement<ObtenerProductosResponse> createObtenerProductosResponse(ObtenerProductosResponse value) {
        return new JAXBElement<ObtenerProductosResponse>(_ObtenerProductosResponse_QNAME, ObtenerProductosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IngresarProductoCompraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "ingresarProductoCompraResponse")
    public JAXBElement<IngresarProductoCompraResponse> createIngresarProductoCompraResponse(IngresarProductoCompraResponse value) {
        return new JAXBElement<IngresarProductoCompraResponse>(_IngresarProductoCompraResponse_QNAME, IngresarProductoCompraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarArchivoCarroResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.server.com/", name = "cargarArchivoCarroResponse")
    public JAXBElement<CargarArchivoCarroResponse> createCargarArchivoCarroResponse(CargarArchivoCarroResponse value) {
        return new JAXBElement<CargarArchivoCarroResponse>(_CargarArchivoCarroResponse_QNAME, CargarArchivoCarroResponse.class, null, value);
    }

}
