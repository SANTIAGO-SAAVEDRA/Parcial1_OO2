package test;

import java.time.LocalDate;

import modelo.SistemaEstacionamiento;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SistemaEstacionamiento sist = new SistemaEstacionamiento();
		
		sist.agregarVehiculo("AAA111", "Auto", 11111111);
		sist.agregarVehiculo("AAA222", "Auto", 22222222);
		sist.agregarVehiculo("CCC333", "Camioneta", 33333333);
		sist.agregarVehiculo("CCC444", "Camioneta", 44444444);


		sist.agregarLugar(1, 100);
		sist.agregarLugar(1, 101);
		sist.agregarLugar(1, 102);
		sist.agregarLugar(1, 103);
		sist.agregarLugar(2, 200);
		sist.agregarLugar(2, 201);
		sist.agregarLugar(2, 202);
		sist.agregarLugar(2, 203);
		
		sist.agregarOcupacion(sist.traerLugar(1, 102), sist.traerVehiculo("AAA111"), LocalDate.of(2025, 8, 29));
		sist.agregarOcupacion(sist.traerLugar(2, 201), sist.traerVehiculo("CCC333"), LocalDate.of(2025, 9, 3));
		sist.agregarOcupacion(sist.traerLugar(1, 100), sist.traerVehiculo("AAA222"), LocalDate.of(2025, 9, 12));
		sist.agregarOcupacion(sist.traerLugar(2, 203), sist.traerVehiculo("CCC444"), LocalDate.of(2025, 9, 14));

		sist.marcarSalida(sist.traerVehiculo("AAA111"), LocalDate.of(2025, 9, 2));
		sist.marcarSalida(sist.traerVehiculo("CCC444"), LocalDate.of(2025, 9, 15));
		
		// NO SE PUEDE AGREGAR EL VEHICULO YA QUE EXISTE SU DOMINIO.
		//sist.agregarVehiculo("CCC333", "Camioneta", 33333333);
		
		sist.agregarOcupacion(sist.traerLugar(1, 100), sist.traerVehiculo("AAA222"), LocalDate.of(2025, 9, 12));

		System.out.println(sist.getLstVehiculos() + "\n");
		System.out.println(sist.getLstLugares() + "\n");
		System.out.println(sist.getLstOcupaciones() + "\n");
		System.out.println(sist.traerOcupacionesPorFechaIngreso(LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 12)) + "\n");
		
		System.out.println(sist.traerVehiculosEstacionadosActuales() + "\n");
		
		System.out.println(sist.traerOcupacionesPorTipoVehiculo("Camioneta"));
		
		
	}

}
