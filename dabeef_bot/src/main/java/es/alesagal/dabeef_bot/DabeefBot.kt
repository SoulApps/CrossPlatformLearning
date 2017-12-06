package es.alesagal.dabeef_bot

import de.btobastian.sdcf4j.Command
import de.btobastian.sdcf4j.CommandExecutor

class DabeefBot : CommandExecutor {

    // Comandos
    companion object {
        private const val COMANDO = "delegate."
        private const val INSULTAR = "insultar"
        private const val DEP = "dep"
        private const val ODOO = "odoo"
    }

    @Command(aliases = arrayOf(COMANDO + INSULTAR))
    fun insultar(vararg args: String): String {
        val insulto = StringBuilder("Tú si que eres ")

        if (args.isNotEmpty()) {
            for (i in args.indices) {
                if (i > 0)
                    insulto.append(" y ")
                insulto.append(args[i])
            }
            return insulto.toString()
        } else {
            return "Mala pécora"
        }
    }

    @Command(aliases = arrayOf(COMANDO + DEP))
    fun dep(): String {
        return "DEEEEEP"
    }

    @Command(aliases = arrayOf(COMANDO + ODOO))
    fun odoo(): String {
        return "NI NO NINONINO NINONINO"
    }
}