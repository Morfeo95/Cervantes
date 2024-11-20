📚 Librería Cervantes

¡Bienvenido a Librería Cervantes! Este proyecto es una aplicación en Java que gestiona libros y autores con funcionalidades avanzadas como búsqueda, estadísticas y filtrado de datos. La aplicación utiliza repositorios y herramientas para interactuar con bases de datos y manipular información sobre libros y autores.

🛠️ Funcionalidades

    Buscar Libro
    Permite buscar libros por nombre e integrarlos a la base de datos si no existen.

    Listar Libros Buscados
    Muestra todos los libros registrados en la base de datos.

    Listar Autores Registrados
    Despliega una lista de todos los autores disponibles.

    Listar Autores durante un Periodo de Tiempo
    Encuentra autores vivos en un año específico.

    Listar Libros por Idioma
    Filtra los libros según el idioma seleccionado.

    Estadísticas de Libros Descargados
    Genera estadísticas como el promedio, total y número de descargas.

    Top 10 Libros más Descargados
    Presenta los diez libros más populares según las descargas.

    Buscar Autores por Nombre
    Encuentra un autor específico por su nombre.

    Filtrar Autor por Año de Muerte
    Busca autores según el año de su fallecimiento.

    Filtrar Autor por Año de Nacimiento
    Filtra autores basándose en su año de nacimiento.

    Salir
    Finaliza la ejecución del programa.

📂 Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

    com.francisco.libreria_cervantes
    Contiene la clase principal Principal que gestiona la interacción del usuario.

    com.francisco.libreria_cervantes.herramientas
    Incluye herramientas como el Buscador para realizar búsquedas de libros.

    com.francisco.libreria_cervantes.modelos
    Define las clases modelo como Libro.

    com.francisco.libreria_cervantes.repositorio
    Contiene los repositorios LibroRepository y AutorersRepository para gestionar los datos de libros y autores.

🚀 Instalación y Ejecución
Prerrequisitos

    Java 11+
    IDE como IntelliJ IDEA, Eclipse o similar
    Maven configurado en el sistema

Pasos para Ejecutar

    Clona este repositorio:

    git clone https://github.com/tu-usuario/libreria-cervantes.git

Importa el proyecto en tu IDE favorito como un proyecto Maven.
Ejecuta la clase Principal desde el paquete com.francisco.libreria_cervantes.
Sigue las instrucciones del menú para interactuar con la aplicación.



📈 Tecnologías Utilizadas

    Java: Lenguaje principal para el desarrollo.
    Maven: Gestión de dependencias y configuración del proyecto.
    Stream API: Manipulación de colecciones y generación de estadísticas.
    Scanner: Captura de entrada del usuario.
    Repositorio Personalizado: Gestión de persistencia de datos.

🖥️ Vista Previa del Menú

********************************
Bienvenido a la Librería Cervantes.
Elija una opción:
1).- Buscar Libro.
2).- Listar libros Buscados.
3).- Listar Autores Registrados.
4).- Listar Autores durante un periodo de tiempo.
5).- Listar libros por idioma.
6).- Estadísticas de libros descargados.
7).- Top 10 libros más descargados.
8).- Buscar Autores por nombre.
9).- Filtrar Autor por año de muerte.
10).- Filtrar Autor por año de Nacimiento.
0).- Salir.
********************************

📌 Notas

    Asegúrate de tener configuradas las dependencias necesarias para ejecutar la base de datos si es requerida.
    La funcionalidad depende de los métodos implementados en los repositorios LibroRepository y AutorersRepository.

🧑‍💻 Contribuciones

¡Contribuciones son bienvenidas! Si tienes ideas para mejorar el proyecto, no dudes en abrir un issue o enviar un pull request.
