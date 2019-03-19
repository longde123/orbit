/*
 Copyright (C) 2015 - 2018 Electronic Arts Inc.  All rights reserved.
 This file is part of the Orbit Project <http://www.orbit.cloud>.
 See license in LICENSE.
 */

package cloud.orbit.dsl.ast

data class DataField(
    val name: String,
    val type: Type,
    val index: Int
) : AstNode
