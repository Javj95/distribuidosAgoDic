const mongoose=require('mongoose');
const esquema=mongoose.Schema;

const estEsquema=new esquema({
    cedula:{type: String, unique:true, required:true},
    nombre:{type: String, required:true},
    apellidoPaterno:{type: String, required:true},
    apellidoMaterno:{type: String, required:true},
    departamento:{type: String, required:true},
    puesto:{type: String, required:true},
    especialidad:{type: String, required:true},
    permisoExpedientes:[{curp: String, paciente: String}]
});

module.exports=mongoose.model('Doctores',estEsquema);
                            //nombre de la collecion
                            //en la BD