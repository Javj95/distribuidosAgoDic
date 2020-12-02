const express = require('express');
const router = express.Router();
const mongoose = require('mongoose');

const Doctor = require('../models/doctor');

// Ruta dedicada a consultar un doctor por su cedula
router.get("/:cedula", (req, res) => {
    const cedula = req.params.cedula;
    Doctor.findOne({ cedula: cedula })
        .exec()
        .then(doc => {
            res.status(200).json(doc);
        }).catch(err => {
            console.log(err);
            res.status(500).json({
                error: err
            })
        });
});

// Ruta dedicada a registrar un doctor nuevo
router.post("/", (req, res) => {
    console.log(req.body);
    const doctor = new Doctor({
        cedula: req.body.curp,
        nombre: req.body.nombre,
        apellidoPaterno: req.body.apellidoPaterno,
        apellidoMaterno: req.body.apellidoMaterno,
        departamento: req.body.departamento,
        puesto: req.body.puesto,
        especialidad: req.body.especialidad,
        permisoExpedientes: []
    });
    doctor.save()
        .then(result => {
            console.log(result);
        }).catch(err => console.log(err));
    res.status(200).json({
        message: "Funciona!",
        doctor: doctor
    });
});

module.exports = router;