<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\EventController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

Route::get('/', [EventController::class, 'index']);
Route::get('/produtos', [EventController::class, 'products']);
Route::get('/products/{id}', [EventController::class, 'purchase']);
//Route::get('/info', [EventController::class, 'info']);
Route::post('/products',[EventController::class, 'store']);


