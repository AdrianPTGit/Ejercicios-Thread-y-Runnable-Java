# 🧩 Práctica: Hilos en Java — Cuenta Atrás y Métodos de Thread

---

## **1️⃣ Ejecución del programa original**

### **Preguntas**

- ¿Qué está pasando con la ejecución del programa anterior?
- Tras ejecutarlo, ¿el mensaje **"Comienza la cuenta atrás!"** está puesto en el sitio correcto?
- Intenta crear más instancias de la clase `LiftOff` y haz que se ejecuten todas (dentro del `main`).
- Si observas la salida de la aplicación, ¿está haciendo algo diferente a una aplicación monohilo?
- ¿Qué puedes extraer de la salida del programa?

---

## **2️⃣ Clase `LiftOff` heredando de `Thread`**

### **Instrucciones**

1. Copia el ejemplo original de la *Cuenta Atrás* y haz que la clase `LiftOff` **herede de `Thread`**.
2. En vez de llamar directamente al método `run()`, haz que los *threads* llamen al método `start()`.

### **Preguntas**

- ¿El mensaje **"Comienza la cuenta atrás!"** aparece ahora en el sitio correcto?
- ¿Por qué sale antes si en el código está después?
- Crea nuevas instancias de `LiftOff` y haz que se lancen en el `main`.
- ¿En qué ha cambiado ahora la ejecución de la aplicación respecto a una aplicación monohilo?
- ¿Qué puedes extraer de la salida del programa?

---

## **3️⃣ Separación de clases y uso de `Runnable`**

### **Instrucciones**

1. Copia el código de `ThreadMethodsExample` y **divídelo en dos clases**:
    - Una que contenga la clase que **extiende de `Thread`**.
    - Otra que contenga el **método `main`** y el código para crear y lanzar los hilos.
2. Cambia `U3S2_ThreadMethodsExample` para que **implemente la interfaz `Runnable`**.
3. Realiza los cambios necesarios en la otra clase para que todo vuelva a funcionar como antes.

---
## 🧠 Resumen de comportamiento

| Método usado | Tipo de ejecución       | Orden de salida       | Observación                                   |
|---------------|------------------------|------------------------|-----------------------------------------------|
| `.run()`      | Monohilo (secuencial)  | Siempre el mismo       | No hay concurrencia                           |
| `.start()`    | Multihilo (concurrente)| Variable, no predecible| Se ejecutan varios hilos al mismo tiempo      |

## 🧠 Resumen Clase `Thread` y metodos

| Elemento                   | Descripción                                                                 |
|-----------------------------|------------------------------------------------------------------------------|
| `extends Thread`            | Permite que la clase se comporte como un hilo independiente.                |
| `run()`                     | Método que define la tarea que ejecutará el hilo.                           |
| `start()`                   | Inicia un nuevo hilo y llama internamente al método `run()`.                |
| `run()` (llamado directamente) | No crea un nuevo hilo; ejecuta el código en el hilo actual.              |

## 🧠 Resumen clase `MyRunnable` con `implements Runnable`

| Elemento            | Descripción                                                                 |
|----------------------|------------------------------------------------------------------------------|
| `implements Runnable`| Permite definir una tarea que puede ejecutarse en un hilo.                  |
| `run()`              | Contiene el código que ejecutará el hilo cuando se inicie.                  |
| `new Thread(new MyRunnable()).start()` | Crea e inicia un hilo que ejecutará el método `run()` de `MyRunnable`. |

> ❗ Ventaja principal   
- Permite heredar de otra clase y separar la lógica del hilo de su ejecución. 
