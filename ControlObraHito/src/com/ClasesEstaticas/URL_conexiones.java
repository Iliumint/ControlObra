package com.ClasesEstaticas;

public class URL_conexiones {
	
	
//Verificador estado del servidor
static public final String ESTADO_SERVIDOR="http://192.168.0.113:8081/ControldeObras/usuarioCO/availeServer";	
	
	
//Conexiones locales GRODCO  -- USUARIOS	
static public final String PEDIR_UN_USUARIO="http://192.168.0.113:8081/ControldeObras/usuarioCO/getItem/";//+{id}
static public final String PEDIR_USUARIOS="http://192.168.0.113:8081/ControldeObras/usuarioCO/getAllItems";
static public final String VERIFICAR_LOGIN="http://192.168.0.113:8081/ControldeObras/usuarioCO/loginUser";
static public final String INSERTAR_USUARIO="http://192.168.0.113:8081/ControldeObras/usuarioCO/insUser2";

////Conexiones locales APARTAMENTO  -- USUARIOS	
//static public final String PEDIR_UN_USUARIO="http://192.168.0.15:8081/ControldeObras/usuarioCO/getItem/";//+{id}
//static public final String PEDIR_USUARIOS="http://192.168.0.15:8081/ControldeObras/usuarioCO/getAllItems";
//static public final String VERIFICAR_LOGIN="http://192.168.0.15:8081/ControldeObras/usuarioCO/loginUser";
//static public final String INSERTAR_USUARIO="http://192.168.0.15:8081/ControldeObras/usuarioCO/insUser2";


// De la tabla de Movimiento de Materiales
static public final String PEDIR_REGISTRO_MOVMAT="";
static public final String PEDIR_VARIOS_REGISTROS_MOVMAT="";
static public final String INSERTAR_REGISTRO_MOVMAT="http://192.168.0.113:8081/ControldeObras/MovimientoMateriales/insMovMat";


//De la tabla de Intalacion de Tuberias
static public final String PEDIR_REGISTRO_INSTUB="";
static public final String PEDIR_VARIOS_REGISTROS_INSTUB="";
static public final String INSERTAR_REGISTRO_INSTUB="http://192.168.0.113:8081/ControldeObras/InstalacionTuberias/insInsTub";

//De la tabla de Maquinaria
static public final String PEDIR_REGISTRO_MAQUINARIA="";
static public final String PEDIR_VARIOS_REGISTROS_MAQUINARIA="";
static public final String INSERTAR_REGISTRO_MAQUINARIA="http://192.168.0.113:8081/ControldeObras/Maquinaria/insMaquina";

//De la tabla de Caoncreto
static public final String PEDIR_REGISTRO_CONCRETO="";
static public final String PEDIR_VARIOS_REGISTROS_CONCRETO="";
static public final String INSERTAR_REGISTRO_CONCRETO="http://192.168.0.113:8081/ControldeObras/Concreto/insConcreto";

//De la tabla de Relleno de Obra
static public final String PEDIR_REGISTRO_RELLENOS="";
static public final String PEDIR_VARIOS_REGISTROS_RELLENOS="";
static public final String INSERTAR_REGISTRO_RELLENOS="http://192.168.0.113:8081/ControldeObras/RellenoObras/insRellenos";

//De la tabla de Clima y personal
static public final String PEDIR_REGISTRO_CLIMA="";
static public final String PEDIR_VARIOS_REGISTROS_CLIMA="";
static public final String INSERTAR_REGISTRO_CLIMA="http://192.168.0.113:8081/ControldeObras/ClimaPersonal/insClima";

}
