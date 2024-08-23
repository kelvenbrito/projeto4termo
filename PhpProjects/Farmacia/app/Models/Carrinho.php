<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Carrinho extends Model
{
    use HasFactory;

    protected $fillable = [
        'id_medicamento', 'id_user', 'quantidade', 'status'
    ];

    public function medicamento()
    {
        return $this->belongsTo(Medicamentos::class, 'id_medicamento');
    }
}
