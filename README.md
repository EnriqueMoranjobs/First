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

## Login

Es nuestra pantalla de inicio de sesión.
En el  arbol de componentes tenemos :
  *Constraint layout
  *Dos guide line para centrar los componentes en nuestra pantalla
  *Dos editview para nuestros TextEdit de "Usuario" y "Password".
  *Dos botones de "Entra" con un Onclick a la activity Main  y "Registrate" con un Onclick a la activity SignUp. Tienen funcionalidades que explicaremos en breve
  *Un ImageView con el logo de nuestra app.
  *Un Glide para darle fondo, este difumina dos colores que da un aspecto bonito a la app
  
 En el java de Login tenemos:
  * Glide para carga la imagen de la chica: 
  
   //glide para cargar la imagen de girls
        Glide.with(this)
                //carga imagen, hay que dar permiso a internet en android manifest
                .load(R.drawable.girl)
                //transition hae que cargue la imagen un poco mas tarde
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .into(mgirl);
  
  * Onclicks para ir a Main y a SignUp
  *  public void openMain(View w){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        
           *intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);   --> Pila de tareas
           *intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); --> Nos libera la pila de tareas sacandonos de la app
           *startActivity(intent);
    *}

     *public void openSignUp(View w){
        *Intent intent = new Intent(LoginActivity.this,SignUp.class);
        *startActivity(intent);
    *}




