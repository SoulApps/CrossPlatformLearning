<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/*
| -------------------------------------------------------------------------
| URI ROUTING
| -------------------------------------------------------------------------
| This file lets you re-map URI requests to specific controller functions.
|
| Typically there is a one-to-one relationship between a URL string
| and its corresponding controller class/method. The segments in a
| URL normally follow this pattern:
|
|	example.com/class/method/id/
|
| In some instances, however, you may want to remap this relationship
| so that a different class/function is called than the one
| corresponding to the URL.
|
| Please see the user guide for complete details:
|
|	https://codeigniter.com/user_guide/general/routing.html
|
| -------------------------------------------------------------------------
| RESERVED ROUTES
| -------------------------------------------------------------------------
|
| There are three reserved routes:
|
|	$route['default_controller'] = 'welcome';
|
| This route indicates which controller class should be loaded if the
| URI contains no data. In the above example, the "welcome" class
| would be loaded.
|
|	$route['404_override'] = 'errors/page_missing';
|
| This route will tell the Router which controller/method to use if those
| provided in the URL cannot be matched to a valid route.
|
|	$route['translate_uri_dashes'] = FALSE;
|
| This is not exactly a route, but allows you to automatically route
| controller and method names that contain dashes. '-' isn't a valid
| class or method name character, so it requires translation.
| When you set this option to TRUE, it will replace ALL dashes in the
| controller and method URI segments.
|
| Examples:	my-controller/index	-> my_controller/index
|		my-controller/my-method	-> my_controller/my_method
*/
$route['default_controller'] = 'welcome';
$route['404_override'] = '';
$route['translate_uri_dashes'] = FALSE;


//Profesor
$route['profesor']['post'] = 'profesor/login';
$route['profesor/(:any)']['post'] = 'profesor/logout/$1';

//Aula
$route['aula']['get'] = 'aula/getAll';

//Reserva
$route['reserva/(:any)/(:any)/(:any)']['get'] = 'reserva/getDay/$1/$2/$3';
$route['reserva']['post'] = 'reserva/post';
$route['reserva/(:any)/(:any)/(:any)/(:any)']['delete'] = 'reserva/delete/$1/$2/$3/$4';

//Hardware
$route['hardware']['get'] = 'hardware/getAll';
$route['hardware']['post'] = 'hardware/post';
$route['hardware/(:any)']['put'] = 'hardware/put/$1';

//Material
$route['material/(:any)/(:any)']['get'] = 'material/getAllByAula/$1/$2';
$route['material/(:any)']['get'] = 'material/getAllByHardware/$1';
$route['material']['post'] = 'material/post';
$route['material/(:any)']['delete'] = 'material/delete/$1';

//Incidencia
$route['incidencia']['get'] = 'incidencia/getAll';
$route['incidencia']['post'] = 'incidencia/post';
$route['incidencia/(:any)']['put'] = 'incidencia/put/$1';
