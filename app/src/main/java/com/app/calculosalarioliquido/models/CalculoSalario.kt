package com.app.calculosalarioliquido.models

import java.math.BigDecimal

data class CalculoSalario (val salarioBruto: BigDecimal, val desconto: BigDecimal? = BigDecimal.ZERO)

