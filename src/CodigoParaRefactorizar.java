public class CodigoRefactorizado {

    private static final double IVA = 0.21;

    public double calcularPrecioConIva(double precioBase) {
        return precioBase * (1 + IVA);
    }

    public double calcularPrecioConIvaYDescuento(double precioBase, double porcentajeDescuento) {
        double precioConIva = calcularPrecioConIva(precioBase);
        return precioConIva * (1 - porcentajeDescuento / 100);
    }

    public int obtenerDiasDelMes(int mes, int anio) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esBisiesto(anio) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Mes inválido: " + mes);
        }
    }

    private boolean esBisiesto(int anio) {
        return (anio % 400 == 0) || ((anio % 4 == 0) && (anio % 100 != 0));
    }

    public double aplicarSubidaDePrecio(double precioBase, double subida) {
        double nuevoPrecioBase = precioBase + subida;
        double precioConIva = calcularPrecioConIva(nuevoPrecioBase);
        imprimirPrecios(nuevoPrecioBase, precioConIva);
        return nuevoPrecioBase;
    }

    private void imprimirPrecios(double precioBase, double precioConIva) {
        System.out.println("El nuevo precio base es " + precioBase);
        System.out.println("El precio con IVA es " + precioConIva);
    }
}
