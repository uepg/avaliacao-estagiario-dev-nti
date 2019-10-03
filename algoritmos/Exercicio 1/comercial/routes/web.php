<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});
Route::prefix('produto')->group(function () {
    Route::get('/', 'ProdutoController@index')->name('produto.index');

    Route::get('/create', 'ProdutoController@create')->name('produto.create');
    Route::get('/edit/{id}', 'ProdutoController@edit')->name('produto.edit');
    Route::get('/show/{id}', 'ProdutoController@show')->name('produto.show');

    Route::post('/store', 'ProdutoController@store')->name('produto.store');
    Route::post('/update/{id}', 'ProdutoController@update')->name('produto.update');

    Route::delete('/delete/{id}', 'ProdutoController@delete')->name('produto.delete');
});

Route::prefix('venda')->group(function () {
    Route::get('/', 'VendaController@index')->name('venda.index');

    Route::get('/create', 'VendaController@create')->name('venda.create');
    Route::get('/edit/{id}', 'VendaController@edit')->name('venda.edit');
    Route::get('/show/{id}', 'VendaController@show')->name('venda.show');

    Route::post('/store', 'VendaController@store')->name('venda.store');
    Route::post('/update/{id}', 'VendaController@update')->name('venda.update');

    Route::delete('/delete/{id}', 'VendaController@delete')->name('venda.delete');
});
