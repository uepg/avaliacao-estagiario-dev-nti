<?php

namespace App\Controllers;

class Home extends BaseController
{
    private $vendaModel;
    private $vendaItemModel;
    private $itemModel;

    public function __construct()
    {
        $this->vendaModel = new \App\Models\VendaModel();
        $this->vendaItemModel = new \App\Models\VendaItemModel();
        $this->itemModel = new \App\Models\ItemModel();
    }

    /*
    public function index()
    {
        return view('welcome_message');
    }
    */

    public function index()
    {
    
        $data = [
            'titulo' => 'Home',
        ];

        return view('Home/index', $data);
    }
}
