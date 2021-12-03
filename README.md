# First ✨

**Primer contacto con la APP**
Aqui la situamos en la Activity principal del emulador de nuesto dispositivo.
![image](https://user-images.githubusercontent.com/91469065/144382426-5383c524-ad50-4308-b8ca-5d52f0a509a6.png)
Le agregamos un icono personalizado, con un Image Asset.

# Activities
* La aplicación consta de  cuatro activities Splash, Login, Main, y Sign Up en la que el Login será la protagonista al incorporar la mayoria de funcionalidades,las explicaremos, y las del resto de activities mas adelante.
1. Splash
2. Login
3. Sign Up
4. Main
## Splash
Es nuestra pantalla de carga,y presentación de la App, en ella mostramos un nombre y un icono.
Lo mas destacado es una animación en el que barco rota dándole dinamismo y una óptica agradable al usuario, con la que este identificará a nuestra marca en el futuro.

Para la animación creamos una carpeta en res llamada anim en el que dentro metimos un xml llamado fadein con la configuración de nuestra animación.
Enlazaremos en con nuestra clase en Java con esta línea.


*Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
*star.startAnimation(myanim);

![splash](https://user-images.githubusercontent.com/91469065/144668668-5635b656-dc44-4a66-81d6-627a643e2e4d.gif)

## Login

Es nuestra pantalla de inicio de sesión.
En el  arbol de componentes tenemos :
  *Constraint layout
  *Dos guide line para centrar los componentes en nuestra pantalla
  *Dos editview para nuestros TextEdit de "Usuario" y "Password".
  *Dos botones de "Entra" con un Onclick a la activity Main  y "Registrate" con un Onclick a la activity SignUp. Tienen funcionalidades que explicaremos en breve
  *Un ImageView con el logo de nuestra app.
  *Un Gradient para darle fondo, este difumina dos colores que da un aspecto bonito a la app
  *Un Glide para cargar una imagen de fondo.
  
 En el java de Login tenemos:
  * Glide para carga la imagen de la chica: 
  
        * Glide.with(this)
        
        * .load(R.drawable.girl)
        
        * .transition(DrawableTransitionOptions.withCrossFade(100))
        
        * .into(mgirl);
  
  **Onclicks para ir a Main y a SignUp**
    public void openMain(View w){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        
           intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);   --> Pila de tareas
           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); --> Nos libera la pila de tareas sacandonos de la app
           startActivity(intent);
   }

     public void openSignUp(View w){
        Intent intent = new Intent(LoginActivity.this,SignUp.class);
        startActivity(intent);
     }
     
     ![main](https://user-images.githubusercontent.com/91469065/144668798-52dd75f3-1ab5-49e9-bd4f-97484cd5ea71.gif)

     
 ## SignUp
 Es nuestra Activity de registro, es una página sencilla sin funcionalidad
 En el  arbol de componentes tenemos :
  *Constraint layout
  *Dos guide line para centrar los componentes en nuestra pantalla
  *Tres InputLayout para nuestros EditText de "Usuario","Password" y Email.
  *Un boton de "Logueate" sin funcionalidad.
  *Un Gradient para darle fondo, este difumina dos colores que da un aspecto bonito a la app
  *Un Glide con el fondo de un chico.
  
  ![signup](https://user-images.githubusercontent.com/91469065/144668813-9ded4616-98ec-437e-9cd8-760d7b80b0ea.gif)

  
   ## Main
  
  Es la Activity con mas funcionalidad en nuestra App
  
  En el  arbol de componentes tenemos :
  *Constraint layout
  *webview
  
  Creamos un top en el que añadimos dos items mediante un xml llamado menu_top situado en en res dentro de una carpeta llamada menu.
  
  ![xmlTop](https://user-images.githubusercontent.com/91469065/144669506-4b83ba5f-5ed6-4a54-9c0e-aa996041b5e5.PNG)
  
  Aqui podemos ver que hemos implementado un dialogo modal con tres opciones una que nos lleve al signup,, otra que no haga nada y otra llamada "other".
  
 ![top](https://user-images.githubusercontent.com/91469065/144669592-0937836d-32de-42fa-8765-6d32f55260cc.gif)

 
 

  
La vista dentro es un webview con permiso para zoom, implementamos dentro de la web view una página web con fotos de personas aleatorias.

si clickeamos hacia arriba podemos ver como cambia la foto y sale el icono de espera.

![swiperefres](https://user-images.githubusercontent.com/91469065/144669563-71830117-ac87-454c-b786-13dc5fe9122b.gif)


Aqui podemos observar un menu contextual que cuando hacemos un click largo nos despliega dos opciones. Si clickeamos en copy nos saldra un snackbar que nos llevará a otro si pulsamos en "deshacer", nos saldrá "accion restaurada".

![taplong](https://user-images.g![top](https://user-images.githubusercontent.com/91469065/144669486-ed43d721-59dc-4176-a9f2-4622e22267bd.gif)



  
     





