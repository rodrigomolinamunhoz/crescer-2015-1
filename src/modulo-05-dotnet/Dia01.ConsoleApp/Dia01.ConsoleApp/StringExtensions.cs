using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dia01.ConsoleApp.DuendeVerde
{
    internal static class StringExtensions
    {
        internal static string ToBacon(this string str, bool? upperCase = true)
        {
            if (upperCase.HasValue && upperCase.Value)
            {
                return str + " BACON!!!";
            }
            else
            {
                return str + " bacon!!!";
            }
        }
    }
}
