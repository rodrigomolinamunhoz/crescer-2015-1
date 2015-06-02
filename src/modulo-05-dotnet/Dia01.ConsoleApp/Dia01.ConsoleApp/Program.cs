using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using Dia01.ConsoleApp.DuendeVerde;

namespace Dia01.ConsoleApp
{
    class Program
    {
        string _variavel;

        static void Main(string[] args)
        {
            #region dynamic

            dynamic oi = new ExpandoObject();
            oi.Saudacao = "Ta se loco";

            Console.WriteLine(oi.Saudacao);

            #endregion

            #region Arraiiiii

            var numeros = new[] { 1, 2, 3 }.ToList();
            //IList<int> numeros = new List<int>(new [] { 1, 2, 3 });
            //numeros.AddRange(new[] { 4, 5 });
            //var numeros = new List<int>(capacity: 10);

            //string str1 = "Ana";

            /*for (int i = 0; i < 6000; i++)
            {
                Console.WriteLine(i);
            }*/

            //foreach (var i in numeros)
            //{
            //    Console.WriteLine(i);
            //}

            Action<int> imprimir = i => Console.WriteLine(i + " bacon");

            numeros.ForEach(imprimir);
            new[] { 5, 6, 7 }.ToList().ForEach(imprimir);
            new[] { 8, 9, 10 }.ToList().ForEach(imprimir);

            #endregion

            #region Extension Methods

            Console.WriteLine("Ana".ToBacon(null));

            #endregion

            #region Jedi

            var yoda = new Jedi
            {
                Name = "Yoda",
                Grau = Grau.MESTRE
            };

            var baconJedi = new
            {
                Name = yoda.Name.ToBacon()
            };

            Console.WriteLine(yoda.Name);

            #endregion

            #region DateTime

            DateTime agora = DateTime.Now;

            #endregion

            Console.ReadLine();
        }
    }

}
