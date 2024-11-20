package com.francisco.libreria_cervantes.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
