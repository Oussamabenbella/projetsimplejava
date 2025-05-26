-- Création de la table des destinations
CREATE TABLE IF NOT EXISTS destinations (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    image_url VARCHAR(255),
    rating DECIMAL(3,1),
    cost_estimate DECIMAL(10,2)
);

-- Insertion de données initiales
INSERT INTO destinations (name, country, description, image_url, rating, cost_estimate) VALUES
('Paris', 'France', 'La ville de l''amour avec sa tour Eiffel emblématique et sa cuisine de renommée mondiale.', 'https://images.unsplash.com/photo-1502602898657-3e91760cbb34', 4.7, 1200.00),
('Rome', 'Italie', 'La ville éternelle avec son Colisée et son riche patrimoine historique.', 'https://images.unsplash.com/photo-1552832230-c0197dd311b5', 4.6, 1100.00),
('Barcelone', 'Espagne', 'Connue pour son architecture distinctive et sa vie nocturne animée.', 'https://images.unsplash.com/photo-1583422409516-2895a77efded', 4.5, 950.00),
('New York', 'États-Unis', 'La ville qui ne dort jamais, avec ses gratte-ciels imposants et sa diversité culturelle.', 'https://images.unsplash.com/photo-1496442226666-8d4d0e62e6e9', 4.8, 1500.00),
('Tokyo', 'Japon', 'Un mélange fascinant de tradition et de haute technologie.', 'https://images.unsplash.com/photo-1536098561742-ca998e48cbcc', 4.9, 1300.00),
('Marrakech', 'Maroc', 'Une ville impériale connue pour ses marchés, ses palais et ses jardins.', 'https://images.unsplash.com/photo-1597212720158-8e5dae9b201a', 4.4, 800.00),
('Sydney', 'Australie', 'Célèbre pour son opéra emblématique et ses plages magnifiques.', 'https://images.unsplash.com/photo-1506973035872-a4ec16b8e8d9', 4.7, 1700.00),
('Rio de Janeiro', 'Brésil', 'Réputé pour ses plages, le Carnaval et la statue du Christ Rédempteur.', 'https://images.unsplash.com/photo-1483729558449-99ef09a8c325', 4.5, 1100.00),
('Le Caire', 'Égypte', 'Accueil des pyramides de Gizeh et du Sphinx, des merveilles du monde antique.', 'https://images.unsplash.com/photo-1572252009286-268acec5ca0a', 4.3, 750.00),
('Bangkok', 'Thaïlande', 'Connue pour ses temples ornés, sa street food et sa vie nocturne.', 'https://images.unsplash.com/photo-1563492065599-3520f775eeed', 4.4, 800.00);
